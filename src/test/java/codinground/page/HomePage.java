package codinground.page;

import codinground.domain.FlightBooking;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

import static codinground.DateUtils.formatDate;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HotelBookingPage goToHotelBooking() {
        driver.findElement(By.linkText("Hotels")).click();
        return new HotelBookingPage(driver);
    }

    public void doBooking(FlightBooking booking) {
        selectOneWay();
        chooseOrigin(booking.getSource());
        chooseDestination(booking.getDestination());
        chooseDepartDate(booking.getDepartDate());
        submit();
    }

    public void selectOneWay() {
        driver.findElement(By.id("OneWay")).click();
    }

    public void chooseOrigin(String origin) {
        chooseAutoComplete(origin, By.id("FromTag"), By.cssSelector("#ui-id-1 > .list:nth-child(1)"));
    }

    public void chooseDestination(String destination) {
        chooseAutoComplete(destination, By.id("ToTag"), By.cssSelector("#ui-id-2 > .list:nth-child(1)"));
    }

    public void chooseDepartDate(Date date) {
        pickDate(By.id("DepartDate"), date);
    }

    public void submit() {
        driver.findElement(By.id("SearchBtn")).click();
    }

    public boolean isSearchSummaryPresent() {
        return isElementPresent(By.className("searchSummary"));
    }

    public static HomePage moveToHomePage(WebDriver driver) {
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        return new HomePage(driver);
    }
}
