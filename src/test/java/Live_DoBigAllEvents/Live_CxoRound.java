package Live_DoBigAllEvents;

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

public class Live_CxoRound {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.tatatelebusiness.com/dobig-cxoround/");
    }	

    @Test
    public void testLoadCxoRound() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@id='acceptcookie']")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent popup not found or already accepted.");
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

        List<WebElement> cxoRounds = driver.findElements(By.tagName("h2"));
        List<String> cxoRoundNames = new ArrayList<>();
        
        for (WebElement cxoRound : cxoRounds) {
            cxoRoundNames.add(cxoRound.getText());
        }

        System.out.println("Total cxoRound Count for live_All: " + cxoRoundNames.size());
        System.out.println("cxoRound Names:");
        for (String name : cxoRoundNames) {
            System.out.println(name);
        }

        Assert.assertTrue(cxoRoundNames.size() > 0, "No cxoRound studies were loaded.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
