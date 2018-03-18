package utils;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import org.junit.runners.Parameterized;

@RunWith(Cucumber.class)

@CucumberOptions(
        strict = false,
        features = "src/test/resources/features",
        glue = {"stepDefs"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class TestRunner {
}
