package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchStepDefs {

    WebDriver driver;
    SearchPage searchPage;

    public SearchStepDefs() {
        driver = Hooks.driver;
        searchPage = new SearchPage();
    }


    @Given("^User is on Search page$")
    public void userIsOnSearchPage() {
        Assert.assertTrue("Not able to open search page", searchPage.openSearchPage());
    }

    @When("^User search for \"([^\"]*)\"$")
    public void userSearchFor(String searchQuery) {
        Assert.assertTrue("Failed to search for: " + searchQuery, searchPage.doSearch(searchQuery));
    }

    @Then("^\"([^\"]*)\" results has been found$")
    public void resultsHasBeenFound(String expectedNumOfResults) {
        searchPage.checkNumberOfResults(expectedNumOfResults);
    }

    @Then("^In results there is an item: \"([^\"]*)\" with the price: \"([^\"]*)\"$")
    public void inResultsThereIsAnItemWithThePrice(String searchQuery, String price)  {
        searchPage.checkIfProductWithPriceIsInResults(searchQuery, price);
    }
}

