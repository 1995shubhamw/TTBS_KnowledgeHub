package seoTagging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Strategy 
{
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        

        try 
        {
            
            String url = "https://stg.tatatelebusiness.com/articles/strategies-to-navigate-whatsapp-business-api-messaging-limits/";
            System.out.println(url);
            driver.get(url);

            
            String expectedTitle = "Strategies to Navigate WhatsApp Business API Messaging Limits by TTBS";
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
            String expectedDescription = "Discover how to navigate WhatsApp Business API Messaging Limits. Explore strategies, best practices, and solutions to Elevate Messaging Tier to boost customer engagement";
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
            String expectedKeywords = "WhatsApp send unlimited message,increase whatsapp broadcast limit,whatsapp message sending limit per day,whatsapp bulk message limit";
            String actualKeywords = metaKeywords.getAttribute("content");
           
            if (actualKeywords.equalsIgnoreCase(expectedKeywords) )
            {
                System.out.println("Meta keywords are correct.");
            } 
            else 
            {
                System.out.println("Meta keywords are incorrect");
                System.out.println("Expected: " + expectedKeywords);
                System.out.println("Found: " + actualKeywords);
            }

            
            WebElement canonicalTag = driver.findElement(By.xpath("//link[@rel='canonical']"));
            String expectedCanonical = "https://www.tatatelebusiness.com/articles/strategies-to-navigate-whatsapp-business-api-messaging-limits/";
            String actualCanonical = canonicalTag.getAttribute("href");
            
            if (actualCanonical.equals(expectedCanonical)) 
            {
                System.out.println("Canonical tag is correct.");
            } 
            else 
            {
                System.out.println("Canonical tag is incorrect. Expected: " + expectedCanonical);
                System.out.println("Found: " + actualCanonical);
            }

            
            WebElement h1 = driver.findElement(By.tagName("h1"));
            String expectedH1 = "Scaling Smart: Strategies to Navigate WhatsApp Business API Messaging Limits";
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
