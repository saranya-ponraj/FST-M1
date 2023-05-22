package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
public class AlertTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void openPage() {
        //Create Instances
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void openSimpleAlert() {
        driver.findElement(By.cssSelector("#simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void openConfirmAlert() {
        driver.findElement(By.cssSelector("#confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void openPromptAlert() {
        driver.findElement(By.cssSelector("#prompt")).click();
    }

    @Then("^Alert opens$")
    public void switchFocus() {
        alert = driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readAlert() {
        System.out.println("Alert says: " + alert.getText());
    }

    @And("^Write a custom message in it$")
    public void writeToPrompt() {
        alert.sendKeys("Custom Message");
    }

    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeAlertWithCAncel() {
        alert.dismiss();
    }

    @And("^Close Browser$")
    public void closeBrowser() {
        driver.close();
    }
}
