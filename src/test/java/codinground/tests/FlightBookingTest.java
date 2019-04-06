package codinground.tests;

import codinground.common.BaseTest;
import codinground.common.ReadingTestData;
import codinground.domain.FlightBooking;
import codinground.page.HomePage;
import org.testng.annotations.Test;

import static codinground.common.DateUtils.today;
import static org.testng.Assert.assertTrue;

public class FlightBookingTest extends BaseTest {

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        HomePage homePage = HomePage.moveToHomePage(driver);
        homePage.doBooking(new FlightBooking(ReadingTestData.getData("From"), ReadingTestData.getData("To"), today()));

        assertTrue(homePage.isSearchSummaryPresent());
    }
}
