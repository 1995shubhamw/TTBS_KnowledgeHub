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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ImageChecker {

    @Test
    public void checkImagesOnPages() {
       ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Disable pop-ups
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // List of URLs to visit
        List<String> urls = new ArrayList<>();
        urls.add("https://ttbs-migration-dev.allsocialassets.com/articles/");
        
       
        List<String> excludedPaths = List.of(
        		"/images/menu/smart-internet-menu.png",
        		"/images/menu/smartflo-menu.png",
        		"/images/menu/smart-office-menu.png",
        		"/images/menu/zoom-menu.png",
        		"/images/award-menu-icon.png",
        		"/images/menu/data-services-menu01.png",
        		"/images/menu/data-services-menu02.png",
        		"/images/menu/voice-services-menu01.png",
        		"/images/menu/voice-services-menu02.png",
        		"/images/menu/marketing-solutions-menu01.png",
        		"/images/menu/marketing-solutions-menu02.png",
        		"/images/menu/cyber-security-menu01.png",
        		"/images/menu/cyber-security-menu02.png",
        		"/images/menu/industry-menu01.png",
        		"/images/menu/industry-menu02.png",
        		"/images/menu/need-menu01.png",
        		"/images/menu/need-menu02.png",
        		"/images/menu/organisation-menu01.png",
        		"/images/menu/organisation-menu02.png",
        		"/images/menu/top-content-menu01.png",
        		"/images/menu/top-content-menu02.png",
        		"/images/menu/top-content-menu03.png",
        		"/images/menu/podcast/podcast-1.jpg",
        		"/images/menu/podcast/thumb-podcast-2.webp",
        		"/images/arrow-black.svg",
        		"/images/menu/article/azure-ai.webp",
        		"/images/menu/article/thumb-02.png",
        		"/images/menu/article/managed-wi-fi",
        		"/images/menu/case-studies/leading-logistics.png",
        		"/images/menu/case-studies/faurecia-a-global.png",
        		"/images/menu/case-studies/leading-steel.png",
        		"/images/menu/infographics/thumb-04.png",
        		"/images/menu/infographics/thumb-05.png",
        		"/images/menu/infographics/thumb-06.png",
        		"/images/menu/whitepapers/head-thumb.jpg",
        		"/images/menu/whitepapers/thumb-02.png",
        		"/images/menu/whitepapers/thumb-03.png",
        		"/images/menu/smartflo-big-menu.png",
        		"/images/menu/microsoft-365-menu.png",
        		"/images/menu/featured-pages/smartflo-virtual-phone-numbers-menu-banner.webp",
        		"/images/menu/smart-internet-menu.webp",
        		"/images/menu/call-recording-features-page.jpg",
        		"/images/audit.svg",
        		"/images/industry.svg",
        		"/images/menu/imanage-mobile.png",
        		"/images/menu/imanage.png",
        		"/images/got-questions-img-1.png",
        		"/images/infographics-white.png",
        		"/images/link-arrow.svg",
        		"/images/case-studies-white.png",
        		"/images/cookies.svg",
        		"/images/inner-banner/TTML01-mobile.jpg",
        		"/images/inner-banner/TTML01-desktop.jpg",
        		"Found 0 images on the page.",
        		"/images/search.svg",
        		"/images/enter.svg",
        		"/images/arrow.svg",
        		"/images/menu-whatsapp.png",
        		"/images/close.svg",
        		"/images/back.svg",
        		"/images/trophy-star.svg",
        		"Found 238 images on the page.",
        		"/images/whatsapp.png",

        		"/images/got-questions-img-2.png"

        );

        for (String url : urls) {
            try {
                // Open the URL
               // System.out.println("Opening URL: " + url);
                driver.get(url);

                // Handle cookie pop-up if present
                try {
                    WebElement cookieButton = driver.findElement(By.id("rejectcookie"));
                    cookieButton.click();
                  //  System.out.println("Cookie pop-up handled.");
                } catch (Exception e) {
                 //   System.out.println("No cookie pop-up found.");
                }

                // Find all images on the page
                List<WebElement> images = driver.findElements(By.tagName("img"));
               // System.out.println("Found " + images.size() + " images on the page.");

                boolean restrictedImageFound = false;

                for (WebElement img : images) {
                    // Check the `data-src` attribute
                    String imageUrl = img.getAttribute("data-src");

                    // Skip if the `data-src` is null or empty
                    if (imageUrl == null || imageUrl.isEmpty()) {
                        continue;
                    }

                    // Skip base64 images (e.g., data:image/png;base64,...)
                    if (imageUrl.startsWith("data:image")) {
                        continue;
                    }

                    // Check if the image URL is part of the excluded paths
                    boolean isExcluded = excludedPaths.stream().anyMatch(imageUrl::contains);
                    if (isExcluded) {
                        continue;
                    }

                    // Check the accessibility of the image URL
                    int responseCode = getResponseCode(imageUrl);
                    if (responseCode == 403 || responseCode == 404) {
                        restrictedImageFound = true;
                        break; // No need to check further images on this page
                    }
                }

                if (restrictedImageFound) {
                    System.out.println("Restricted image found on page: " + url);
                }

            } catch (Exception e) {
                System.out.println("Error occurred while processing URL: " + url);
                e.printStackTrace();
            }
        }

        // Close the browser
        driver.quit();
    }

    /**
     * Checks the HTTP response code for the given URL.
     *
     * @param imageUrl The URL to check.
     * @return The HTTP response code.
     */
    private int getResponseCode(String imageUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("Failed to check image URL: " + imageUrl);
            return -1; // Return -1 for any errors
        }
    }
}
