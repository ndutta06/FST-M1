package activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class activity4 {
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
    public void loginTest() {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));

        //Enter credentials
        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        //Click login
        driver.findElement(By.id("bigbutton")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // identify homepage
        WebElement homePage = driver.findElement(By.id("tab0"));
        System.out.println("Login Message is : " + homePage.getText());

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
