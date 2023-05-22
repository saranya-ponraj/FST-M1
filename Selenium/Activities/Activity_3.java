package ACTIVITIES;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity_3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://www.training-support.net/selenium/login-form");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the username field and enter the username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        // Find the login button and click it
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        Thread.sleep(2000);
        // Print the confirmation message
        String message = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
        System.out.println("Login message: " + message);

        // Close the browser
        driver.close();
    }
}
