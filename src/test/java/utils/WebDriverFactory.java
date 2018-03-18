package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static final long implicit_wait_timeout = 5;
    private static final int script_timeout = 5;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }

    private static String getBrowser() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = System.getenv("browser");
            if (browser == null) {
                browser = "chrome";
            }
        }
        return browser;
    }

    public static void startBrowser() {
        if (driver == null) {
            switch (getBrowser().toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser type");
            }
            driver.manage().timeouts().implicitlyWait(implicit_wait_timeout, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(script_timeout, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getHomeUrl() {
        String homeUrl = System.getProperty("homeUrl");
        if (homeUrl == null) {
            homeUrl = System.getenv("homeUrl");
            if (homeUrl == null) {
                homeUrl = "https://test.com";
            }
        }
        return homeUrl;
    }

    public static void takeScreenShot() {
        System.out.println("NOT IMPLEMENTED: ScreenShot method called");
    }

    public static void logBrowserVersion(WebDriver driver) {
        if (driver instanceof HasCapabilities) {
            Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
            Log.info("BrowserName=" + capabilities.getBrowserName() +
                    " Version=" + capabilities.getVersion() + " Platform=" + capabilities.getPlatform());
        } else {
            Log.info("BrowserName=" + driver.getClass().getName());
        }
    }
}
