package mobile.test.automation.core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static mobile.test.automation.utils.PropertyManager.get;

public class DriverManager {

    private final String urlAddress = "http://127.0.0.1:4723/wd/hub";
    private static DriverManager instance;
    private WebDriverWait waiter;
    private AndroidDriver driver;

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null)
                    instance = new DriverManager();
            }
        }
        return instance;
    }

    public AndroidDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }

    private void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", get("platform.name"));
        capabilities.setCapability("deviceName", get("device.name"));
        capabilities.setCapability("platformVersion", get("platform.version"));
        capabilities.setCapability("appPackage", get("app.package"));
        capabilities.setCapability("appActivity", get("app.activity"));
        capabilities.setCapability("noReset", "true");

        URL serverAddress;
        try {
            serverAddress = new URL(urlAddress);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Illegal URL address: " + urlAddress, e);
        }
        driver = new AndroidDriver(serverAddress, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waiter = new WebDriverWait(driver, 60);
    }

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public WebElement text(String text) {
        return find(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]"));
    }

    public WebElement exactText(String text) {
        return find(By.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public WebElement wait(By locator) {
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement wait(WebElement element) {
        return waiter.until(ExpectedConditions.visibilityOf(element));
    }

    public void back() {
        getDriver().navigate().back();
    }

    public void quit() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
