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

public class activity6 {
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
    public void menuChecking() {
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

        //locate the navigation menu

        WebElement navigationMenu = driver.findElement(By.id("toolbar"));
        if (navigationMenu != null) {
            System.out.println("Element found by xpath");

        }


        //ensure that 'activities' menu item exists

        WebElement activitiesMenu = driver.findElement(By.id("grouptab_3"));

        if (activitiesMenu.getText() != null) {
            System.out.println(activitiesMenu.getText() + " menu item exists");

        }

        else {
            System.out.println("activities menu item not present");
        }
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
