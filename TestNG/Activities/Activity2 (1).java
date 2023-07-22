package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void driverinititae() {
        // Set up the Firefox driver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.out.println("Driver initiated");
        //Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void testCase1() {
        //Title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Title of the page is :" + pageTitle);
        //Assert page title
        Assert.assertEquals(pageTitle, "Target Practice");
    }

    @Test
    public void testCase2() {
        WebElement blackButton = driver.findElement(By.xpath("//button[@class='ui black button']"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test(enabled = false)
    public void testCase3() {
        Assert.assertTrue(false);
    }

    @Test
    public void testCase4() throws SkipException {
        String condition = "123";
        if (condition.equalsIgnoreCase("123")){
            throw new SkipException("Test skipped");
        }
    }

    @AfterClass
    public void closedriver() {
        //Closet the driver
        driver.close();
        System.out.println("Driver closed");
    }


}
