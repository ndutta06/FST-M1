package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLOutput;

public class Activity1 {

    WebDriver driver;

    @BeforeMethod
    public void driverinititae() {
        // Set up the Firefox driver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.out.println("Driver initiated");
        //Open the browser
        driver.get("https://www.training-support.net");
    }

    @Test
    public void test() {
        //Title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Title of the page is :" + pageTitle);
        //Assert page title
        Assert.assertEquals(pageTitle,"Training Support");
        //Find the clickable link on the page and click it
        driver.findElement(By.id("about-link")).click();
        //Print title of new page
        System.out.println("New page title is: " + driver.getTitle());
        //Assert new page title
        Assert.assertEquals(driver.getTitle(),"About Training Support");

    }

    @AfterMethod
    public void closedriver() {
        //Closet the driver
        driver.close();
        System.out.println("Driver closed");
    }


}
