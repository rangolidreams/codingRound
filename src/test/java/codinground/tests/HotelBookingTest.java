package codinground.tests;

import codinground.common.BaseTest;
import codinground.common.ReadingTestData;
import codinground.domain.HotelBooking;
import codinground.page.HomePage;
import codinground.page.HotelBookingPage;
import org.testng.annotations.Test;

import static codinground.common.DateUtils.nDaysFromToday;
import static codinground.common.DateUtils.tomorrow;
import static codinground.domain.HotelBooking.Travellers.ONE_ROOM_TWO_ADULTS;
import static org.testng.Assert.assertTrue;

public class HotelBookingTest extends BaseTest {

    @Test
    public void shouldBeAbleToSearchForHotels() {
        HomePage homePage = HomePage.moveToHomePage(driver);
        HotelBookingPage hotelBookingPage = homePage.goToHotelBooking();

        hotelBookingPage.bookHotel(new HotelBooking(
                ReadingTestData.getData("Locality"),
                ONE_ROOM_TWO_ADULTS,
                tomorrow(),
                nDaysFromToday(3)));
        assertTrue(hotelBookingPage.isElementResultVisible());

    }
}
