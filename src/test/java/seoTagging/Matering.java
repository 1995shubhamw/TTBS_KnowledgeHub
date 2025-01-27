package seoTagging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Matering 
{
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        

        try 
        {
            
            String url = "https://stg.tatatelebusiness.com/articles/whatsapp-business-api-messaging-limits/";
            System.out.println(url);
            driver.get(url);

            
            String expectedTitle = "WhatsApp Business API Messaging Limits: Your Step-by-Step Guide";
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle))
            {
                System.out.println("Title tag is correct.");
            } 
            else 
            {
                System.out.println("Title tag is incorrect. Expected: " + expectedTitle);
                System.out.println("Found: " + actualTitle);
                
            }

            
            WebElement metaDescription = driver.findElement(By.xpath("/html/head/meta[1]"));
            String expectedDescription = "Discover WhatsApp Business API Messaging Limits with TTBS. Learn the importance of messaging limits, API integration, and best practices to enhance business communication";
            String actualDescription = metaDescription.getAttribute("content");
            
            if (actualDescription.equals(expectedDescription)) 
            {
                System.out.println("Meta description is correct.");
            } 
            else 
            {
                System.out.println("Meta description is incorrect");
                System.out.println("Expected: " + expectedDescription);
                System.out.println("Found: " + actualDescription);
            }

            
            WebElement metaKeywords = driver.findElement(By.xpath("//meta[@name='Keywords']"));
            String expectedKeywords = "whatsapp broadcast limit,whatsapp business message limit per day,whatsapp message sending limit per day,whatsapp business broadcast limit";
            						   
            String actualKeywords = metaKeywords.getAttribute("content");
            
           
            if (actualKeywords.equals(expectedKeywords)) 
            {
                System.out.println("Meta keywords are correct.");
            } 
            else 
            {
                System.out.println("Meta keywords are incorrect. Expected: " + expectedKeywords);
                System.out.println("Found: " + actualKeywords);
            }

            
            WebElement canonicalTag = driver.findElement(By.xpath("//link[@rel='canonical']"));
            String expectedCanonical = "https://www.tatatelebusiness.com/articles/whatsapp-business-api-messaging-limits/";
            String actualCanonical = canonicalTag.getAttribute("href");
            
            if (actualCanonical.equals(expectedCanonical)) 
            {
                System.out.println("Canonical tag is correct.");
            } 
            else 
            {
                System.out.println("Canonical tag is incorrect. Expected: " + expectedCanonical + ", Found: " + actualCanonical);
            }

            
            WebElement h1 = driver.findElement(By.tagName("h1"));
            String expectedH1 = "Mastering WhatsApp Business API Messaging Limits: Your Step-by-Step Guide";
            String actualH1 = h1.getText();
            
            if (actualH1.equals(expectedH1)) 
            {
                System.out.println("H1 tag is correct.");
            } 
            else 
            {
                System.out.println("H1 tag is incorrect. Expected: " + expectedH1);
                System.out.println("Found: " + actualH1);
            }

        }
        catch (Exception e) 
        {
            System.out.println("An error occurred: " + e.getMessage());
        } 
        finally 
        {
            
            driver.quit();
        }
    }
}
