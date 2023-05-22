package HRM_Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Activity_9  {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void loginCredential() {
        // Find the username field and enter the username
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        // Find the password field and enter the password
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        // Find the login button and click it
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();


    }

    @Test  (dependsOnMethods = { "loginCredential" })
    public void EmergencyContact() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//b[normalize-space()='My Info']")).click();
        Thread.sleep(2000);
        // Create the Actions object to page down
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Emergency Contacts']")).click();
        Thread.sleep(2000);
        //WebElement cellValue = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr/td[4]"));
        //System.out.println("the contacts listed in the table: " + cellValue.getText());

        // Print the contacts listed in the table
        List<WebElement> MobileColumn = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr/td[5]"));
        System.out.println("The contacts listed in the table: ");
        for(WebElement cell : MobileColumn) {
            System.out.println(cell.getText());
        }


    }


    @AfterClass
    public void afterClass() {
        driver.close();


    }
}
