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

public class Activity_7  {
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
    public void Qualification() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//b[normalize-space()='My Info']")).click();
        Thread.sleep(2000);
        // Create the Actions object to page down
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Qualifications')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
        driver.findElement(By.xpath("//input[@id='experience_employer']")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@id='experience_jobtitle']")).sendKeys("Automation Tester");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnWorkExpSave']")).click();


    }


    @AfterClass
    public void afterClass() {
        driver.close();


    }
}
