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

public class Activity_8  {
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
    public void Dashboard() throws InterruptedException {
        driver.findElement(By.xpath("//b[normalize-space()='Dashboard']")).click();
       Thread.sleep(2000);
        driver.findElement(By.xpath("(//div)[30]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("DayOff");
        driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).click();
        driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).sendKeys("2023-06-06");
        driver.findElement(By.xpath("//li[3]//img[1]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).click();
       // driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).sendKeys("2023-06-05");
        //driver.findElement(By.xpath("//li[3]//img[1]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();
        String Status = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText();
        String date = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        System.out.println("Leave submitted for : " + date);
        System.out.println("Leave Status : " + Status);

    }


    @AfterClass
    public void afterClass() {
        driver.close();


    }
}
