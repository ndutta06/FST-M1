package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        //URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Test method
    @Test
    public void verifyHeadingAndAboutUS() {
        // Perform the calculation
        driver.get("https://www.training-support.net/");

        // Find heading on the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Training Support']")));
        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='Training Support']"
        )).getText();

        // Print to console
        System.out.println("Heading: " + pageHeading);
        // Find heading of new page and print to console
        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='About Us']"
        )).getText();
        System.out.println("About page: " + aboutPageHeading);

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
