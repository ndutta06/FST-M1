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

public class activity9 {

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



        for(int r=1; r<11;r++)
        {
            String name = driver.findElement (By.xpath("//table[contains(@class,'responsive')]/tbody/tr["+r+"]/td[3]")).getText();
            String user = driver.findElement (By.xpath("//table[contains(@class,'responsive')]/tbody/tr["+r+"]/td[8]")).getText();

            System.out.println("Name displayed in Row number "+r+" is: "+name+" and respective User ID is: "+user);
        }



    }


    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
