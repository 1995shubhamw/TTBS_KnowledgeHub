package Live_All;

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


public class Live_Article {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tatatelebusiness.com/articles/");
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

        List<WebElement> articles = driver.findElements(By.tagName("h2"));
        List<String> articlesNames = new ArrayList<>();
        for (WebElement article : articles) 
        {
            articlesNames.add(article.getText());
        }
        System.out.println("Total article Count for live_All: " + articlesNames.size());
        System.out.println("article Names:");
        for (String name : articlesNames)
        {
            System.out.println(name);
        }

        Assert.assertTrue(articlesNames.size() > 0, "No articles were loaded.");
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
