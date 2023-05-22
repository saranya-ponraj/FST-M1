package HRM_Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity_4  {
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
    public void HomePage() {
        String Tittle = driver.getTitle();
        System.out.println("New page title is: " + Tittle);

        Assert.assertEquals(Tittle, "OrangeHRM");


    }
    @Test  (dependsOnMethods = { "HomePage" })
    public void PIM() {
        driver.findElement(By.xpath("(//h1[normalize-space()='Dashboard'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//b[normalize-space()='PIM'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//input[@id='btnAdd'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//input[@id='firstName'])[1]")).sendKeys("Saranya");
        driver.findElement(By.xpath("(//input[@id='lastName'])[1]")).sendKeys("Ponraj");
        driver.findElement(By.xpath("(//input[@id='btnSave'])[1]")).click();

    }
    @Test  (dependsOnMethods = { "PIM" })
    public void EmployeeIsPresent() {
        driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Saranya Ponraj");
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        WebElement Employee = driver.findElement(By.xpath("//tr[@class='odd']")) ;
        System.out.println("Employee is created: " + Employee.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.close();


    }
}
