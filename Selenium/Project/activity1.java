package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity1 {


    // Declare the WebDriver object
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }


    @Test
    public void readTitle() {
        // Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Title is: " + title);
        //Assertion for page title
        Assert.assertEquals(title, "SuiteCRM");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
