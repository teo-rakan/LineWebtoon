package mobile.test.automation.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.test.automation.core.DriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    DriverManager driverManager = DriverManager.getInstance();

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getInstance().getDriver()), this);
        waitUntilLoaded();
    }

    public abstract void waitUntilLoaded();
}
