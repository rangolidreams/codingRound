package codinground.tests;

import codinground.BaseTest;
import codinground.page.HomePage;
import codinground.domain.FlightBooking;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertTrue;

public class FlightBookingTest extends BaseTest {

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        Date today = new Date();
        HomePage homePage = HomePage.moveToHomePage(driver);
        homePage.doBooking(new FlightBooking("Bangalore", "Delhi", today));

        assertTrue(homePage.isSearchSummaryPresent());
    }
}
