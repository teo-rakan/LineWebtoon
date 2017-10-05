package mobile.test.automation.tests;

import mobile.test.automation.core.AppiumTest;
import mobile.test.automation.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DailyFeaturedTest extends AppiumTest {

    @Test
    public void checkDailyComicTab() {
        String selectedTabName = new HomePage().viewTodayComics().getSelectedTabTitle().toLowerCase();
        String expectedTabName = LocalDate.now().getDayOfWeek().name().substring(0,3).toLowerCase();
        Assert.assertEquals(selectedTabName, expectedTabName);
    }
}
