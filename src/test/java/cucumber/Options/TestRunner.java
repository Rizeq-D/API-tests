package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/rizeq/Desktop/Asured_maven_project" +
        "/src/main/java/api_framework/features",
        glue = {"api_framework.stepDefinitions"})
public class TestRunner {
}
