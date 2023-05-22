package ACTIVITIES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Activity_2 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();


        driver.get("https://www.training-support.net/selenium/login-form");

        System.out.println("Home page title: " + driver.getTitle());


        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();


        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);


        driver.close();
    }
}
