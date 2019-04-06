package codinground.tests;

import codinground.BaseTest;
import codinground.domain.FlightBooking;
import codinground.page.HomePage;
import org.testng.annotations.Test;

import static codinground.DateUtils.today;
import static org.testng.Assert.assertTrue;

public class FlightBookingTest extends BaseTest {

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        HomePage homePage = HomePage.moveToHomePage(driver);
        homePage.doBooking(new FlightBooking("Bangalore", "Delhi", today()));

        assertTrue(homePage.isSearchSummaryPresent());
    }
}
