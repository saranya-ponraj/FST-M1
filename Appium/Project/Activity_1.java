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

public class Activity_1 {
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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test (priority = 1)
    public void activityTest1() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("add_task_title")
        ));

        // Enter the details
        driver.findElement(AppiumBy.id(
                "add_task_title"
        )).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        String task1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Tasks']")).getText();
        Assert.assertEquals(task1, "Complete Activity with Google Tasks");


    }
    @Test (priority = 2)
    public void activityTest2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("add_task_title")
        ));


        // Enter the details
        driver.findElement(AppiumBy.id(
                "add_task_title"
        )).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")));
        String task2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")).getText();
        Assert.assertEquals(task2, "Complete Activity with Google Keep");
    }
    @Test (priority = 3)
    public void activityTest3() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        // Wait for elements to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("add_task_title")
        ));


        // Enter the details
        driver.findElement(AppiumBy.id(
                "add_task_title"
        )).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")));
        String task3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")).getText();
        Assert.assertEquals(task3, "Complete the second Activity Google Keep");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
