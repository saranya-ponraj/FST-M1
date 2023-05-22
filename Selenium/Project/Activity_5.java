package HRM_Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity_5  {
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
    public void MyInfo() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//b[normalize-space()='My Info']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Indian");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

    }


    @AfterClass
    public void afterClass() {
        driver.close();


    }
}
