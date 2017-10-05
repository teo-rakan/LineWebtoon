package mobile.test.automation.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class TabPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@selected, 'true')]")
    private AndroidElement currentTab;

    public String getSelectedTabTitle() {
        return currentTab.getText();
    }

    public boolean containsTitle(String title) {
        driverManager.exactText(title);
        return true;
    }

    public ComicDetailsPage clickOnTitle(String title) {
        driverManager.exactText(title).click();
        return new ComicDetailsPage();
    }

    @Override
    public void waitUntilLoaded() {
        driverManager.wait(By.id("com.naver.linewebtoon:id/tab_indicator"));
    }
}
