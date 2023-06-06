package Project;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class Activity_2 {

    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void activityTest1() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("editable_title")
        ));

        // Enter the details
        driver.findElement(AppiumBy.id(
                "editable_title"
        )).sendKeys("NOTE 1");
        driver.findElement(AppiumBy.id(
                "edit_note_text"
        )).sendKeys("To Create new note");
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("index_note_title")));
        String task2 = driver.findElement(AppiumBy.id("index_note_title")).getText();
        Assert.assertEquals(task2, "NOTE 1");
    }
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
