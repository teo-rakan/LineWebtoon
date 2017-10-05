package mobile.test.automation.tests;

import mobile.test.automation.core.AppiumTest;
import mobile.test.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static mobile.test.automation.utils.PropertyManager.get;

public class ReleasesTest extends AppiumTest {

    @Test
    public void checkLastReleaseWasIn3Days() {
        Locale locale = Locale.forLanguageTag(get("locale"));
        String actualDate = new HomePage().viewNewComics().viewTopComicDetails().getLastChapterReleaseDate();
        DateTimeFormatter form = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(locale);
        LocalDate threeDayAgo = LocalDate.now().minusDays(3);
        LocalDate releaseDay = LocalDate.parse(actualDate, form);

        Assert.assertTrue(releaseDay.isAfter(threeDayAgo));
    }
}
