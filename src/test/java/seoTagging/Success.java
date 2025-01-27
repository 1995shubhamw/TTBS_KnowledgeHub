package seoTagging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Success 
{
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        

        try 
        {
            
            String url = "https://stg.tatatelebusiness.com/articles/success-stories-whatsapp-business-api-messaging-limits/";
            System.out.println(url);
            driver.get(url);

            
            String expectedTitle = "WhatsApp Business API Success Stories | Real-Life Strategies & Key Takeaways";
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle))
            {
                System.out.println("Title tag is correct.");
            } 
            else 
            {
                System.out.println("Title tag is incorrect");
                System.out.println("Expected: " + expectedTitle);
                System.out.println("Found: " + actualTitle);
                
            }

            
            WebElement metaDescription = driver.findElement(By.xpath("/html/head/meta[1]"));
            String expectedDescription = "Explore real-life success stories of businesses navigating WhatsApp Business API messaging limits. Learn challenges, steps taken and actions implemented to scale customer communication";
            String actualDescription = metaDescription.getAttribute("content");
            
            if (actualDescription.equals(expectedDescription)) 
            {
                System.out.println("Meta description is correct.");
            } 
            else 
            {
                System.out.println("Meta description is incorrect. Expected: " + expectedDescription);
                System.out.println("Found: " + actualDescription);
            }

            
            WebElement metaKeywords = driver.findElement(By.xpath("//meta[@name='Keywords']"));
            String expectedKeywords = "WhatsApp Business API success stories,WhatsApp API messaging strategies,Business communication solutions,Customer engagement with WhatsApp API ";
            String actualKeywords = metaKeywords.getAttribute("content");
           
            if (actualKeywords.equals(expectedKeywords)) 
            {
                System.out.println("Meta keywords are correct.");
            } 
            else 
            {
                System.out.println("Meta keywords are incorrect");
                System.out.println("Expected: " + expectedKeywords);
                System.out.println("Found: " + actualKeywords);
            }
            
            WebElement h1 = driver.findElement(By.tagName("h1"));
            String expectedH1 = "WhatsApp Business API Messaging Limits: Real-Life Success Stories and Key Takeaways";
            String actualH1 = h1.getText();
            
            if (actualH1.equals(expectedH1)) 
            {
                System.out.println("H1 tag is correct.");
            } 
            else 
            {
                System.out.println("H1 tag is incorrect.");
                System.out.println("Expected: " + expectedH1);
                
            }

            
            WebElement canonicalTag = driver.findElement(By.xpath("//link[@rel='canonical']"));
            String expectedCanonical = "https://www.tatatelebusiness.com/articles/success-stories-whatsapp-business-api-messaging-limits/%20/";
            String actualCanonical = canonicalTag.getAttribute("href");
            
            if (actualCanonical.equals(expectedCanonical)) 
            {
                System.out.println("Canonical tag is correct.");
            } 
            else 
            {
                System.out.println("Canonical tag is incorrect");
                System.out.println("Expected: " + expectedCanonical);
                System.out.println("Found: " + actualCanonical);
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
