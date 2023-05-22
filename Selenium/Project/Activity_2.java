package HRM_Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity_2 {
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
    public void loginTest() {
        WebElement Header_Image = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
        System.out.println("URL of Header image is : " + Header_Image.getAttribute("src"));
    }
    @AfterClass
    public void afterClass() {
        driver.close();


    }
}
