package stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.Log;
import utils.WebDriverFactory;

public class Hooks {
    public static WebDriver driver;


    @Before
    public void setUp(Scenario scenario) throws Exception {

        WebDriverFactory.startBrowser();
        driver = WebDriverFactory.getDriver();
        WebDriverFactory.logBrowserVersion(driver);
        Log.startTestCase(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            WebDriverFactory.takeScreenShot();
        }

        WebDriverFactory.finishBrowser();
        Log.endTestCase(scenario.getName(), scenario.getStatus());
    }
}
