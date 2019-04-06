package codinground.page;

import codinground.domain.FlightBooking;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HomePage extends Page {

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(linkText = "Your trips")
    private WebElement trips;

    @FindBy(id = "OneWay")
    private WebElement oneWay;


    @FindBy(id = "FromTag")
    private WebElement fromTag;


    @FindBy(id="ToTag")
    private WebElement toTag;

    @FindBy(id = "DepartDate")
    private WebElement departDate;


    @FindBy(id="SearchBtn")
    private WebElement searchBtn;

    @FindBy(css = "#ui-id-2 > .list:nth-child(1)")
    private WebElement firstDestinationResult;

    @FindBy(css= "#ui-id-1 > .list:nth-child(1)")
    private WebElement firstSourceResult;

    @FindBy(className="searchSummary" )
    private WebElement searchSummary;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HotelBookingPage goToHotelBooking() {
        hotelLink.click();
        return PageFactory.initElements(driver, HotelBookingPage.class);
    }
    public SignInPage goToYourTrips() {
        trips.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public void doBooking(FlightBooking booking) {
        selectOneWay();
        chooseOrigin(booking.getSource());
        chooseDestination(booking.getDestination());
        chooseDepartDate(booking.getDepartDate());
        search();
    }

    public void selectOneWay() {
        oneWay.click();
    }

    public void chooseOrigin(String origin) {
        chooseAutoComplete(origin, fromTag, firstSourceResult);
    }

    public void chooseDestination(String destination) {
        chooseAutoComplete(destination, toTag, firstDestinationResult);
    }

    public void chooseDepartDate(Date date) {
        pickDate((departDate), date);
    }

    public void search() {
        searchBtn.click();
    }

    public boolean isSearchSummaryPresent() {
        return isElementPresent(searchSummary);
    }

    public static HomePage moveToHomePage(WebDriver driver) {
        driver.get("https://www.cleartrip.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
