package mobile.test.automation.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ReleasesPage extends BasePage {

    @AndroidFindBy(id = "com.naver.linewebtoon:id/title_name")
    private AndroidElement firstComic;

    public ComicDetailsPage viewTopComicDetails() {
        firstComic.click();
        return new ComicDetailsPage();
    }

    @Override
    public void waitUntilLoaded() {
        driverManager.text("New Release");
    }
}
