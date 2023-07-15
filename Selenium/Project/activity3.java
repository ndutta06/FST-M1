package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class activity3 {

    // Declare the WebDriver object
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void getCopyrightText() {
        // identify first copyright text
        WebElement footerText = driver.findElement(By.id("admin_options"));
        //getAttribute() to get text of footer
        System.out.println("First copyright text in the footer is: " + footerText.getText());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}

