package codinground.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

import static codinground.common.DateUtils.formatDate;

abstract public class Page {
    protected final WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }


    protected static void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    protected boolean isElementcontains(String expected,String actual) {
        try {

            return expected.contains(actual);
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    protected void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void chooseAutoComplete(String text, final WebElement autoCompleteBox, final WebElement autoCompleteItem) {
        autoCompleteBox.clear();
        autoCompleteBox.sendKeys(text);
        waitFor(autoCompleteItem);
        autoCompleteItem.click();
    }

    protected void pickDate(WebElement element, Date date) {
        element.sendKeys(formatDate(date) + "\n");
    }
}
