package pageToPageComparison.copy;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageComparison {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ShubhamWatile\\eclipse-workspace\\TTBS_KnowledgesHub\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DataProvider(name = "urlData")
    public Object[][] getUrlData() throws IOException {
        String excelFilePath = "C:\\Users\\ShubhamWatile\\eclipse-workspace\\TTBS_KnowledgesHub\\TTBS Compare.xlsx";
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][2];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue();
            data[i - 1][1] = row.getCell(1).getStringCellValue();
        }

        workbook.close();
        fis.close();
        return data;
    }

    @Test(dataProvider = "urlData")
    public void compareWebPages(String url1, String url2) throws InterruptedException {
        // Open the first URL
        driver.get(url1);
        Thread.sleep(3000);

        // Scroll the page slowly to the bottom
        scrollToEndOfPage();

        // Remove unwanted elements (cookie banners, header, footer, chatbot, form fields, and dropdowns)
        removeUnwantedElements();

        // Extract visible text content from the first page
        String pageContent1 = extractPageContent();

        // Open the second URL
        driver.get(url2);
        Thread.sleep(3000);

        // Scroll the page slowly to the bottom
        scrollToEndOfPage();

        // Remove unwanted elements (cookie banners, header, footer, chatbot, form fields, and dropdowns)
        removeUnwantedElements();

        // Extract visible text content from the second page
        String pageContent2 = extractPageContent();

        // Compare page contents and log missing content if not matched
        if (!pageContent1.equals(pageContent2)) {
            // Find missing content on page 1 (which is present in page 2 but not in page 1)
            String missingContent1 = findMissingContent(pageContent2, pageContent1);
            // Find missing content on page 2 (which is present in page 1 but not in page 2)
            String missingContent2 = findMissingContent(pageContent1, pageContent2);

            if (!missingContent1.isEmpty()) {
                System.out.println("Missing content on Page 1 (" + url1 + "): " + missingContent1);
            }
            if (!missingContent2.isEmpty()) {
                System.out.println("Missing content on Page 2 (" + url2 + "): " + missingContent2);
            }
        } else {
            System.out.println("The content matches for both URLs.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Scroll the page slowly to the bottom.
     */
    private void scrollToEndOfPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollBy(0, 500);"); // Scroll by 500px
            Thread.sleep(500); // Wait for content to load (adjust delay as needed)

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break; // Exit loop when no more content to load
            }
            lastHeight = newHeight;
        }
    }

    /**
     * Extract visible text content from a web page.
     */
    private String extractPageContent() {
        List<WebElement> bodyElements = driver.findElements(By.tagName("body"));
        StringBuilder pageContent = new StringBuilder();

        for (WebElement element : bodyElements) {
            pageContent.append(element.getText());
        }
        return pageContent.toString().trim();
    }

    /**
     * Remove unwanted elements such as cookie consent banners, header, footer, chatbot,
     * form fields (input, textarea), and dropdowns (select).
     */
    private void removeUnwantedElements() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Remove cookie consent banners (common class names for cookies, you may need to adjust these based on your website's structure)
        js.executeScript("document.querySelectorAll('.cookie-banner, .details, .cookie').forEach(e => e.style.display='none');");

        // Remove header and footer (adjust class names/IDs as needed)
        js.executeScript("document.querySelectorAll('.bottom-header.sticky,.footer, .body > footer > div > div > div:nth-child(1)').forEach(e => e.style.display='none');");

        // Remove chatbot or other popups (adjust class names/IDs as needed)
        js.executeScript("document.querySelectorAll('.callout-message, .popup').forEach(e => e.style.display='none');");

        // Remove form fields and dropdowns (input, textarea, select)
        js.executeScript("document.querySelectorAll('input, textarea, select').forEach(e => e.style.display='none');");
    }

    /**
     * Find the missing content from one page that is present on the other page.
     * This is a simple substring search for missing content.
     * 
     * @param fullContent Content from the full page (to check if part of it is missing)
     * @param compareContent Content from the page to compare against.
     * @return Missing content or empty if no missing content.
     */
    private String findMissingContent(String fullContent, String compareContent) {
        if (!fullContent.contains(compareContent)) {
            return fullContent.replace(compareContent, "").trim();
        }
        return "";
    }
}
