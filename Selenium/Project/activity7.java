package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class activity7 {
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
    public void menuChecking() throws InterruptedException {
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

        //Initialize Actions Object
        Actions builder = new Actions(driver);


        // navigate to sales->leads

        WebElement sales = driver.findElement(By.id("grouptab_0"));

        builder.moveToElement(sales).build().perform();

        WebElement Leads = driver.findElement(By.id("moduleTab_9_Leads"));
        Leads.click();

        Thread.sleep(3000);
        //wait
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


        WebElement additionalInfo = driver.findElement(By.xpath("//span[@class='suitepicon suitepicon-action-info']"));
        Thread.sleep(3000);

        additionalInfo.click();
        Thread.sleep(3000);

        WebElement phoneNumber = driver.findElement(By.xpath("//span[@class='phone']"));
        String strPhoneNumber = phoneNumber.getText();

        System.out.println("The Phone number displayed in the pop up is: "+strPhoneNumber);



    }


    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
