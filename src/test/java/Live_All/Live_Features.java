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

public class Live_Features
{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() 
    {
        WebDriverManager.chromedriver().setup();
        
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tatatelebusiness.com/features/");
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

        List<WebElement> features = driver.findElements(By.tagName("h2"));
        List<String> featuresNames = new ArrayList<>();
        
        
        for (WebElement feature : features) 
        {
        	featuresNames.add(feature.getText());
        }

        System.out.println("Total features Count for live: " + featuresNames.size());
        System.out.println("features Names:");
        for (String name : featuresNames) {
            System.out.println(name);
        }

        Assert.assertTrue(featuresNames.size() > 0, "No features were loaded.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
