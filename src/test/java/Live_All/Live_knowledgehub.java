package Live_All;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Live_knowledgehub {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tatatelebusiness.com/knowledgehub/");
    }

    @Test
    public void testLoadCaseStudies() 
    {
        try 
        {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@id='acceptcookie']")));
            acceptCookiesButton.click();
        } 
        catch (Exception e) 
        {
            System.out.println("Cookie consent popup not found or already accepted.");
        }

        while (true) 
        {
            try
            {
                WebElement loadMoreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@href='javascript:;' and @onclick='LoadData()']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreButton);
                Thread.sleep(2000);
            }
            catch (Exception e) 
            {
                break;
            }
        }

        List<WebElement> podcasts = driver.findElements(By.tagName("h2"));
        List<String> podcastNames = new ArrayList<>();
        
        List<String> unwantedTitles = List.of(
                "Connect With Us",
                "Please Fill in Your Details and We'll Call You Back!"
        );

        for (WebElement podcast : podcasts)
        {
            podcastNames.add(podcast.getText());
        }

        System.out.println("Total podcasts Count for migration_All: " + podcastNames.size());
        System.out.println("podcasts Names:");
        for (String name : podcastNames) {
            System.out.println(name);
        }

        Assert.assertTrue(podcastNames.size() > 0, "No podcasts were loaded.");
    }

    @AfterClass
    public void tearDown() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }
}
