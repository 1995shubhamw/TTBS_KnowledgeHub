package campaignPagesBannerChecking;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BannerImage 
{
    private WebDriver driver;
    private WebDriverWait wait;

    public BannerImage() 
    {
       
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<String> checkURLsForBanner(List<String> urls) {
        List<String> urlsWithoutBanner = new ArrayList<>();

        for (String url : urls) {
            try {
                driver.get(url);
                
                // Handle cookie popup - adjust selector based on actual website
                try {
                    WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".cookie-accept-button, #cookie-accept, .accept-cookies")
                    ));
                    acceptCookies.click();
                } catch (Exception e) {
                    //System.out.println("No cookie popup found or unable to handle for: " + url);
                }

                // Check for banner image - adjust selector based on actual website
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(".inner-shadow.right")
                    ));
                } catch (Exception e) {
                    urlsWithoutBanner.add(url);
                    System.out.println("Banner not found on: " + url);
                }

            } catch (Exception e) {
                System.out.println("Error processing URL: " + url);
                System.out.println("Error message: " + e.getMessage());
            }
        }

        return urlsWithoutBanner;
    }

    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }
@Test
    public void mainMethod() {
        // Example usage
        List<String> urls = new ArrayList<>();
        urls.add("https://www.tatatelebusiness.com/campaign/acat/all-category-campaign/");
        urls.add("https://www.tatatelebusiness.com/campaign/north/thinkcybersecurity/thinkcybersecurity/");
        urls.add("https://www.tatatelebusiness.com/campaign/ez-cloud-connect/ez-cloud-connect/");
        urls.add("https://www.tatatelebusiness.com/campaign/ftc/fleet-tracking-campaign-marathi/");
        urls.add("https://www.tatatelebusiness.com/campaign/west/connectivity/smart-internet-leased-line/");
        urls.add("https://www.tatatelebusiness.com/campaign/tollfreeservice/toll-free-service-campaign-hindi/");
        urls.add("https://www.tatatelebusiness.com/campaign/north/collaboration/zoom/");
        urls.add("https://www.tatatelebusiness.com/campaign/hivr/hivr/");
        urls.add("https://www.tatatelebusiness.com/campaign/ftc/fleet-tracking-campaign-hindi/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/smartflouat/");
        urls.add("https://www.tatatelebusiness.com/campaign/tollfreeservice499/toll-free-service-campaign-offer499/");
        urls.add("https://www.tatatelebusiness.com/campaign/thinkcybersecurity/thinkcybersecurity/");
        urls.add("https://www.tatatelebusiness.com/campaign/ftc/fleet-tracking-campaign/");
        urls.add("https://www.tatatelebusiness.com/campaign/tollfreeservice999/toll-free-service-campaign-offer999/");
        urls.add("https://www.tatatelebusiness.com/Campaign/iflex/sdwan/");
        urls.add("https://www.tatatelebusiness.com/campaign/tollfreeservice/toll-free-service-campaign-hindi-499/");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft365/microsoft365-tfn/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartfloucaas/smartfloucaas/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/missed-call-services/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/auto-dialer-services/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/smart-hosted-pbx/");
        urls.add("https://www.tatatelebusiness.com/campaign/north/smartflo/");
        urls.add("https://www.tatatelebusiness.com/campaign/north/microsoft365/microsoft365/");
        urls.add("https://www.tatatelebusiness.com/campaign/sdwan_iflx/");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft_azure/storage_as_a_service");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft_azure/virtual_desktop/");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft365/microsoft365/");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft365/microsoft365withtollfreenumber/");
        urls.add("https://www.tatatelebusiness.com/campaign/sms-solutions-deliver-bulk-messages/");
        urls.add("https://www.tatatelebusiness.com/campaign/truecaller-verified-business-caller-id/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/waba/");
        urls.add("https://www.tatatelebusiness.com/campaign/cybersecurity-email/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartoffice_business_bb.com/");
        urls.add("https://www.tatatelebusiness.com/campaign/end-point-security/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/smartflo_whatsapp/");
        urls.add("https://www.tatatelebusiness.com/campaign/voice-services/sip-trunk/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/smartflo-lite/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/virtual-phone-number/");
        urls.add("https://www.tatatelebusiness.com/campaign/all-products/");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft365/copilot/");
        urls.add("https://www.tatatelebusiness.com/campaign/iot/workforcetracking");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/smartflo-interactions/");
        urls.add("https://www.tatatelebusiness.com/campaign/internet-telephony/internet-telephony/");
        urls.add("https://www.tatatelebusiness.com/campaign/connectivity/smart-internet-leased-line/");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft_azure/migration/");
        urls.add("https://www.tatatelebusiness.com/campaign/le/voicesolution/");
        urls.add("https://www.tatatelebusiness.com/campaign/smartflo/smartflo/");
        urls.add("https://www.tatatelebusiness.com/campaign/microsoft_azure/");
        urls.add("https://www.tatatelebusiness.com/campaign/GoogleWorkspace/");
        urls.add("https://www.tatatelebusiness.com/campaign/toll-free-service-businessplans-hindi/");
        urls.add("https://www.tatatelebusiness.com/campaign/toll-free-service-businessplans/");



        BannerImage checker = new BannerImage();
        try {
            List<String> urlsWithoutBanner = checker.checkURLsForBanner(urls);
            System.out.println("\nURLs without banner images:");
            for (String url : urlsWithoutBanner) {
                System.out.println(url);
            }
        } finally {
            checker.cleanup();
        }
    }
}