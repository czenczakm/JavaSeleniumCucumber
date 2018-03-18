package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverFactory;

import java.util.Map;

public abstract class BasePage extends WebDriverFactory{

    Map<String, WebElement> elementsMap;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    abstract void initMap();

}
