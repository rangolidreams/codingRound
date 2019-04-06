package codinground.page;

import codinground.domain.HotelBooking;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import java.util.Date;

public class HotelBookingPage extends Page {
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;


    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;


    @FindBy(css = "#ui-id-1 > li:nth-child(2) > a")
    private WebElement localityAutoComplete;

    @FindBy(id = "CheckOutDate")
    private WebElement checkOutDate;

    @FindBy(id = "CheckInDate")
    private WebElement checkInDate;

    @FindBy(css= "#ui-id-1 > li:nth-child(2) > a")
    private WebElement firstLocalityResult;

    @FindBy(id= "Result")
    private WebElement result;

    public HotelBookingPage(WebDriver driver) {
        super(driver);
    }
    public HotelBookingPage goToHotelBooking() {
        hotelLink.click();
        return new HotelBookingPage(driver);
    }

    public void bookHotel(HotelBooking hotelBooking) {
        chooseLocality(hotelBooking.getLocality());
        chooseTravellers(hotelBooking.getTravellers());
        chooseCheckIn(hotelBooking.getCheckin());
        chooseCheckout(hotelBooking.getCheckout());
        doSearch();
    }

    private void chooseCheckout(Date checkout) {
        pickDate(checkOutDate, checkout);
    }

    private void chooseCheckIn(Date checkin) {
        pickDate(checkInDate, checkin);
    }

    public void chooseTravellers(HotelBooking.Travellers travellers) {
        new Select(travellerSelection)
                .selectByVisibleText(travellers.text);
    }

    public void doSearch() {
        searchButton.click();
    }

    public void chooseLocality(String locality) {
        chooseAutoComplete(locality, localityTextBox, firstLocalityResult);
    }

    public boolean isElementResultVisible()  {
        return isElementPresent(result);
    }
}
