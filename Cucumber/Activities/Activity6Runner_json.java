package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"json: test-reports2/json-report.json"},
        monochrome = true
)
public class Activity6Runner_json {
}
