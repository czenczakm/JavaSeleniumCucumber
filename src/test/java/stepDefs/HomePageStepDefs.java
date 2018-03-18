package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageStepDefs {

    private WebDriver driver;
    private HomePage homePage;

    public HomePageStepDefs() {
        driver = Hooks.driver;
        homePage = new HomePage();
    }

    @Given("^User is on home page$")
    public void userIsOnHomePage() throws Throwable {
        driver.get("http://automationpractice.com");
    }

    @When("^User search for: \"([^\"]*)\"$")
    public void userSearchFor(String searchQuery) throws Throwable {
        Assert.assertTrue("Not able to do search on home page", homePage.doSearch(searchQuery));
    }

    @Then("^User is redirected to \"([^\"]*)\"$")
    public void userIsRedirectedTo(String expectedUrl) throws Throwable {
        Assert.assertTrue("", driver.getCurrentUrl().contains(expectedUrl));
    }
}
