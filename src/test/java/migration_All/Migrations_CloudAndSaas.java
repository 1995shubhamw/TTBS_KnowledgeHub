package migration_All;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

import io.github.bonigarcia.wdm.WebDriverManager;


public class Migrations_CloudAndSaas {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/");
    }
    @Test
    public void testLoadArticles() 
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

        List<WebElement> cloudAndSaas = driver.findElements(By.tagName("h2"));
        List<String> cloudAndSaasNames = new ArrayList<>();
        for (WebElement cloudAndSaa : cloudAndSaas) 
        {
        	cloudAndSaasNames.add(cloudAndSaa.getText());
        }
        System.out.println("Total cloud and saas assets Count for Migration_All: " + cloudAndSaasNames.size());
        System.out.println("cloud and saas assets Names:");
        for (String name : cloudAndSaasNames)
        {
            System.out.println(name);
        }

        Assert.assertTrue(cloudAndSaasNames.size() > 0, "No cloud and saas assets were loaded.");
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
