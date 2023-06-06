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

public class Activity_3 {
    AndroidDriver driver;
    WebDriverWait wait;


    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Open the page in Chrome
        driver.get("https://www.training-support.net/selenium");
    }

    // Test method
    @Test
    public void ToDoList() throws InterruptedException {
        // Find heading on the page
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        // Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        // Locate element
        driver.findElement(AppiumBy.accessibilityId("To-Do List Elements get added at run time")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText")));

        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        String task1 = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Add tasks to list']")).getText();
        Assert.assertEquals(task1, "Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        String task2 = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Get number of tasks']")).getText();
        Assert.assertEquals(task2, "Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        String task3 = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Clear the list']")).getText();
        Assert.assertEquals(task3, "Clear the list");
    }
    @Test (dependsOnMethods = { "ToDoList" })
    public void cancelList() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Add tasks to list']")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Add tasks to list']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Get number of tasks']")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Get number of tasks']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Clear the list']")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Clear the list']")).click();

    }
    @Test (dependsOnMethods = { "cancelList" })
    public void clearList() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
