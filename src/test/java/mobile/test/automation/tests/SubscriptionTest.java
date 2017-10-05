package mobile.test.automation.tests;

import mobile.test.automation.pages.ComicDetailsPage;
import mobile.test.automation.pages.HomePage;
import mobile.test.automation.pages.TabPage;
import org.junit.Assert;
import org.junit.Test;

public class SubscriptionTest {

    @Test
    public void checkSubscription() {
        ComicDetailsPage detailsPage = new HomePage().viewBanneredComic().subscribe();
        String subscribedComic = detailsPage.getTitle();
        TabPage myPage = detailsPage.backToHomePage().goToSubscribedComics();

        Assert.assertTrue(myPage.containsTitle(subscribedComic));

        myPage.clickOnTitle(subscribedComic).unsubscribe();
    }
}
