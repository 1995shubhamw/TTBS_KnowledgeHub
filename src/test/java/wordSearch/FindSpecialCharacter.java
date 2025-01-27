package wordSearch;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindSpecialCharacter {

    // Set to store visited URLs
    private static final Set<String> visitedUrls = new HashSet<>();

    // Regex pattern to match special characters, excluding specific ones
    private static final Pattern specialCharacterPattern = Pattern.compile("[^\\x00-\\x7F&&[^@’\\-,x₹]]");

    // Characters to exclude explicitly
    private static final Set<Character> excludedCharacters = new HashSet<>(Arrays.asList('×', 'ﬃ', '-', '_', '@', '’', '₹', ',', '®', '“', '©', '–', '”', '‘', '—'));

    // XPath for excluding the footer
    private static final String EXCLUDE_SECTION_XPATH = "//footer";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // Starting URL (homepage of the website)
            String startUrl = "https://ttbs-migration-stg.allsocialassets.com";

            scanWebsite(driver, startUrl);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    /**
     * Scans the website starting from the given URL.
     * @param driver WebDriver instance
     * @param startUrl Starting URL of the website
     */
    private static void scanWebsite(WebDriver driver, String startUrl) {
        Queue<String> urlQueue = new LinkedList<>();
        urlQueue.add(startUrl);

        while (!urlQueue.isEmpty()) {
            String currentUrl = urlQueue.poll();

            // Skip if the URL has already been visited
            if (visitedUrls.contains(currentUrl)) {
                continue;
            }

            try {
                driver.get(currentUrl);
                visitedUrls.add(currentUrl);

                // Exclude footer content
                String pageSourceWithoutFooter = excludeFooter(driver);

                // Scan for special characters on the page
                boolean specialCharacterFound = scanForSpecialCharacters(currentUrl, pageSourceWithoutFooter);

                // If special characters found, output the URL
                if (specialCharacterFound) {
                    System.out.println("Special characters found on page: " + currentUrl);
                }

                // Collect all internal links on the page
                List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
                for (WebElement link : links) {
                    String linkUrl = link.getAttribute("href");

                    // Add only internal links to the queue
                    if (linkUrl != null && linkUrl.startsWith(startUrl) && !visitedUrls.contains(linkUrl)) {
                        urlQueue.add(linkUrl);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error processing URL: " + currentUrl);
                e.printStackTrace();
            }
        }
    }

    /**
     * Excludes the footer content from the page source.
     * @param driver WebDriver instance
     * @return Page source with the footer excluded
     */
    private static String excludeFooter(WebDriver driver) {
        try {
            WebElement footer = driver.findElement(By.xpath(EXCLUDE_SECTION_XPATH));
            return driver.getPageSource().replace(footer.getText(), "");
        } catch (Exception e) {
            // Return full page source if no footer is found
            return driver.getPageSource();
        }
    }

    /**
     * Scans the page content for special characters.
     * @param url The URL of the page being scanned
     * @param pageContent The content of the page
     * @return True if special characters are found; otherwise, false
     */
    private static boolean scanForSpecialCharacters(String url, String pageContent) {
        boolean found = false;

        // Split page content into words for scanning
        String[] words = pageContent.split("\\s+"); // Splits by spaces, tabs, or newlines

        for (String word : words) {
            // Check for special characters in the word
            for (char c : word.toCharArray()) {
                if (c > 127 && !excludedCharacters.contains(c)) {
                    if (!found) {
                        System.out.println("Special characters detected on: " + url);
                        found = true;
                    }
                    System.out.println("Word with special character: " + word);
                    break; // Stop checking this word after detecting one special character
                }
            }
        }

        return found;
    }
}
