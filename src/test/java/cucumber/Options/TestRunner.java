package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/rizeq/Desktop/Asured_maven_project" +
        "/src/main/java/api_framework/features/placeValidations.feature",
        glue = {"stepDefinattions"})
public class TestRunner {
}
