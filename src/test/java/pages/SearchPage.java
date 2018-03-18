package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    private static String SEARCH_URL = "http://automationpractice.com/index.php?controller=search";

    @FindBy(className = "page-heading")
    private WebElement pageHeading;

    @FindBy(id = "search_query_top")
    private WebElement searchBox;

    @FindBy(name = "submit_search")
    private WebElement submitSearch;

    @FindBy(className = "heading-counter")
    private WebElement headingCounter;

    @FindAll({@FindBy(css = ".product_list .product-container")})
    public List<WebElement> productList;

    @Override
    void initMap() {

    }

    public boolean openSearchPage() {
        driver.get(SEARCH_URL);
        return pageHeading.getText().contains("SEARCH");
    }

    public boolean doSearch(String searchQuery) {
        searchBox.clear();
        searchBox.sendKeys(searchQuery);
        submitSearch.click();
        return true;
    }

    public boolean checkNumberOfResults(String expectedNumOfResults) {
        return headingCounter.getText().contains(expectedNumOfResults);
    }

    public void checkIfProductWithPriceIsInResults(String productName, String price) {

        for (WebElement item : productList) {
            String itemName = item.findElement(By.className("product-name")).getText();
            item.findElement(By.cssSelector("h5 > a"));


            if (itemName.contains(productName)) { //TODO

            }
        }
    }
}
