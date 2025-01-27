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

public class Live_Brochures
{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tatatelebusiness.com/brochures/");
    }

    @Test
    public void testLoadBrochures() 
    {
        try 
        {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@id='acceptcookie']")));
            acceptCookiesButton.click();
        } 
        catch (Exception e) 
        {
            System.out.println("Cookie consent popup not found");
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

        List<WebElement> brochures = driver.findElements(By.tagName("h2"));
        List<String> brochuresNames = new ArrayList<>();
        
        
        for (WebElement brochure : brochures) 
        {
            brochuresNames.add(brochure.getText());
        }

        System.out.println("Total brochure Count for live: " + brochuresNames.size());
        System.out.println("brochure Names:");
        for (String name : brochuresNames) {
            System.out.println(name);
        }

        Assert.assertTrue(brochuresNames.size() > 0, "No Brochures were loaded.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
