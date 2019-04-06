package codinground.page;

import codinground.domain.HotelBooking;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class HotelBookingPage extends Page {

    public HotelBookingPage(WebDriver driver) {
        super(driver);
    }

    public void bookHotel(HotelBooking hotelBooking) {
        chooseLocality(hotelBooking.getLocality());
        chooseTravellers(hotelBooking.getTravellers());
        chooseCheckin(hotelBooking.getCheckin());
        chooseCheckout(hotelBooking.getCheckout());
        doSearch();
    }

    private void chooseCheckout(Date checkout) {
        pickDate(By.id("CheckOutDate"), checkout);
    }

    private void chooseCheckin(Date checkin) {
        pickDate(By.id("CheckInDate"), checkin);
    }

    public void chooseTravellers(HotelBooking.Travellers travellers) {
        new Select(driver.findElement(By.id("travellersOnhome")))
                .selectByVisibleText(travellers.text);
    }

    public void doSearch() {
        driver.findElement(By.id("SearchHotelsButton")).click();
    }

    public void chooseLocality(String locality) {
        chooseAutoComplete(locality, By.id("Tags"), By.cssSelector("#ui-id-1 > li:nth-child(2) > a"));
    }
}
