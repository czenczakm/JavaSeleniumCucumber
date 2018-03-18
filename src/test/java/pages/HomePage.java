package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class HomePage extends BasePage {

    @FindBy(id = "search_query_top")
    private WebElement searchBox;

    @FindBy(name = "submit_search")
    private WebElement submitSearch;

    @Override
    void initMap() {
        elementsMap = new HashMap<String, WebElement>() {
            {
            }
        };
    }

    public boolean doSearch(String searchQuery){
        searchBox.clear();
        searchBox.sendKeys(searchQuery);
        submitSearch.click();
        return true;
    }

}
