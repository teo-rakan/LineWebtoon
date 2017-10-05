package mobile.test.automation.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class ComicDetailsPage extends BasePage {

    @AndroidFindBy(id = "com.naver.linewebtoon:id/title_name")
    private AndroidElement title;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/update_date")
    private AndroidElement lastChapterDate;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/add_subscribe")
    private AndroidElement subscribeButton;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/remove_subscribe")
    private AndroidElement unsubscribeButton;

    public String getLastChapterReleaseDate() {
        return lastChapterDate.getText();
    }

    public ComicDetailsPage subscribe() {
        subscribeButton.click();
        driverManager.wait(By.id("com.naver.linewebtoon:id/remove_subscribe"));
        return this;
    }

    public ComicDetailsPage unsubscribe() {
        unsubscribeButton.click();
        driverManager.wait(By.id("com.naver.linewebtoon:id/add_subscribe"));
        return this;
    }

    public HomePage backToHomePage() {
        driverManager.back();
        return new HomePage();
    }

    public String getTitle() {
        return title.getText();
    }

    @Override
    public void waitUntilLoaded() {
        driverManager.wait(By.id("com.naver.linewebtoon:id/update_date"));
    }
}
