package projectActivities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
public class projectActivity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set capb
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        //URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Test method
    @Test
    public void addActivities() {
        // Add new text note
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("New text note"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("editable_title"))).sendKeys("Titel2");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("edit_note_text"))).sendKeys("Description");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//androidx.cardview.widget.CardView")));
        //Get the first note
        String note = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//androidx.cardview.widget.CardView[1]"))).getAttribute("content-desc");
        System.out.println("Added note details are below \n" + note);
        Assert.assertEquals(note,"Titel2. Description. ");


    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }

}
