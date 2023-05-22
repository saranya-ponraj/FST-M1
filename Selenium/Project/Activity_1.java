package HRM_Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity_1 {
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
        String title = driver.getTitle();
        System.out.println("Home page title: " + title);
        Assert.assertEquals(title, "OrangeHRM");
    }
    @AfterClass
    public void afterClass() {
        driver.close();

    }
}
