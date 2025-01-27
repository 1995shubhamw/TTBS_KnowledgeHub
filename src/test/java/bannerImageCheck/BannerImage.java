package bannerImageCheck;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BannerImage {
    @Test
    public void mainMethod() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // List of URLs to visit
        List<String> urls = new ArrayList<>();
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/ez-cloud-connect/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/auto-dialer/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/automated-calling-system/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/microsoft-azure/azure-virtual-desktop/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cyber-security/data-loss-prevention-solution/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/business-broadband/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/business-phone-systems/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/business-phone-systems/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/business-phone-systems/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/call-answering-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/call-center/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/call-management-software/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/call-register-services/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/call-tracking-software/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/voice-services/centrex-service-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/click2call/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-phone-system/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-telephony/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-telephony/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/smartflo/email-platform/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cyber-security/email-security/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cyber-security/endpoint-security/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/google-workspace-solutions/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/hosted-ivr-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/hosted-ivr-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/hosted-ivr-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/hosted-obd-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/hosted-pbx-providers/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/ill-burstable-bandwidth/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/collaboration/international-bridging-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-bangalore/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-chennai/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-kolkata-dalhousie/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-delhi/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-gurgaon-cyber-city/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-gurgaon-sector-45/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-gurgaon-sector-67/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-gurgaon-sikandarpur/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-gurgaon-sohna/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-kolkata-camac-street/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-kolkata-new-town/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-kolkata-salt-lake-city-sector-v/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-mumbai/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-nehru-place/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-nehru-place/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-nehru-place/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-netaji-subhash-place/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-kolkata-nsc-bose-road/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-okhla/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/internet-leased-line-providers-in-pune/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/managed-wifi-jaipur/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/microsoft-azure/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/microsoft-365/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-365-business/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-365-partner/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-365-plans/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-365-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-365-services/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-365-solutions/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/microsoft-365/copilot-ms-365-business/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-office-365-enterprise/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/microsoft-office-pricing/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/missed-call-service-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-ahmedabad/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-ahmedabad/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-ahmedabad/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-chennai/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-chennai/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-chennai/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-chennai/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-in-delhi/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-gurugram/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-gurugram/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-gurugram/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-hyderabad/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-kolkata/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-mumbai/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-pune/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-in-bangalore/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-service-in-noida/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/mpls-vpn-solution/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cyber-security/multifactor-authentication/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/call-masking/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/leased-line-service-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/voice-services/pri-lines-service/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/retail-broadband/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-business/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-companies/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-provider/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-services/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-solutions/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/sd-wan/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/sd-wan/sd-wan-edge/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-iflx-edge-jaipur/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/sd-wan-iflx-jaipur/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/network-connectivity/internet-leased-line/sd-wan-ready-ill/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/voice-services/sip-trunk-services/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/smart-cloud-services/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cyber-security/ddos-prevention/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/smart-internet/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/smart-internet/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/smart-internet-telephony/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/smart-single-number-solution/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/smart-mpls-vpn/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/smartflo/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/business-communication/integrated-solutions/smartflo-cpaas/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/smartflo/ucaas/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/smartflo-UCaaS-jaipur/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/smartoffice/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/sms-solutions/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/tatatelewifi/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/toll-free-services/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/marketing-solutions/truecaller-business-id/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/data-services/ultralola/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cyber-security/virtual-firewall/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/virtual-number/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/voip-number/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cyber-security/web-security/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/cloud-and-saas/smartflo/whatsapp-business-platform/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/whatsapp-for-business-solution/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/whatsapp-for-business/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/whatsapp-for-business/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/whatsapp-for-business-communication/");
       urls.add("https://ttbs-migration-dev.allsocialassets.com/collaboration/zoom/");


       String bannerXPath = "//*[@id=\"content\"]/section[1]/div/figure/picture[2]/img";

       for (String url : urls) {
           // Open the URL
           driver.get(url);
           try {
               // Find the banner image
               WebElement bannerImage = driver.findElement(By.xpath(bannerXPath));
               String imageUrl = bannerImage.getAttribute("src");

               if (imageUrl == null || imageUrl.isEmpty()) {
                   imageUrl = bannerImage.getAttribute("data-src");
               }

               if (imageUrl != null && !imageUrl.isEmpty()) {
                   // Validate the image URL by checking its HTTP response
                   int responseCode = getImageResponseCode(imageUrl);
                   if (responseCode == 404) {
                       System.out.println("URL with 404 image: " + url + " | Image URL: " + imageUrl);
                   }
               } else {
                   System.out.println("No image URL found on: " + url);
               }
           } catch (Exception e) {
               System.out.println("Error on URL: " + url + " - No banner image found");
           }
       }

       // Close the browser
       driver.quit();
   }

   /**
    * Gets the HTTP response code for the given image URL.
    *
    * @param imageUrl The URL of the image to validate.
    * @return The HTTP response code (e.g., 200, 404, etc.).
    * @throws Exception if an error occurs while connecting to the URL.
    */
   private static int getImageResponseCode(String imageUrl) throws Exception {
       HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
       connection.setRequestMethod("HEAD");
       connection.connect();
       return connection.getResponseCode();
   }
}