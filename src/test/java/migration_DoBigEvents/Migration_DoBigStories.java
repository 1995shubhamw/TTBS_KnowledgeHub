package migration_DoBigEvents;

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

public class Migration_DoBigStories
{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get( "http://ttbs-migration-stg.allsocialassets.com/stories/"
+ "");
    }

    @Test
    public void testLoadStories() 
    {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@id='acceptcookie']")));
            acceptCookiesButton.click();
        } 
        catch (Exception e) {
            System.out.println("Cookie consent popup not found");
        }

        while (true) {
        	 try
             {
                 WebElement loadMoreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                         By.xpath("//html/body/div[2]/section[2]/div[3]/div/div/a")));
                 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreButton);
                 Thread.sleep(2000);
             }
        	 catch (Exception e) {
                break;
            }
        }

        List<WebElement> stories = driver.findElements(By.tagName("h2"));
        List<String> storyNames = new ArrayList<>();
        
       

        for (WebElement story : stories) {
            storyNames.add(story.getText());
        }

        System.out.println("Total Stories Count for Migrations: " + storyNames.size());
        System.out.println("Stories Names:");
        for (String name : storyNames) {
            System.out.println(name);
        }

        Assert.assertTrue(storyNames.size() > 0, "No stories were loaded.");
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
