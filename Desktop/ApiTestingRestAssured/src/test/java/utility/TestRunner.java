package utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Path to your feature files
        glue = "stepDefinitions", // Package containing your step definitions
        plugin = {"pretty", "html:target/cucumber-reports"} // Optional: For отчеты
)
public class TestRunner {
    // This class doesn't need to have any methods.  It's just a marker for Cucumber.
}