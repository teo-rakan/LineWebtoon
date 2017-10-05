package mobile.test.automation.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;


public class HomePage extends BasePage {

    @AndroidFindBy(id = "com.naver.linewebtoon:id/btn_new_more")
    private AndroidElement newComicsButton;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/btn_today_more")
    private AndroidElement todayComicsButton;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/big_banner")
    private AndroidElement bigBanner;

    private final By subscribedComicsButton = By.id("com.naver.linewebtoon:id/btn_favorites_more");

    public ReleasesPage viewNewComics() {
        newComicsButton.click();
        return new ReleasesPage();
    }

    public TabPage viewTodayComics() {
        driverManager.scrollTo("Today's Webtoon");
        todayComicsButton.click();
        return new TabPage();
    }

    public ComicDetailsPage viewBanneredComic() {
        bigBanner.click();
        return new ComicDetailsPage();
    }

    public TabPage goToSubscribedComics() {
        driverManager.wait(subscribedComicsButton);
        driverManager.find(subscribedComicsButton).click();
        return new TabPage();
    }

    @Override
    public void waitUntilLoaded() {
        driverManager.wait(By.id("com.naver.linewebtoon:id/big_banner"));
    }
}
