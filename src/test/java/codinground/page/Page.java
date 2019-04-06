package codinground.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

import static codinground.DateUtils.formatDate;

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


    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    protected void chooseAutoComplete(String text, By autoCompleteBox, By autoCompleteItem) {
        driver.findElement(autoCompleteBox).clear();
        driver.findElement(autoCompleteBox).sendKeys(text);
        waitFor(autoCompleteItem);
        driver.findElement(autoCompleteItem).click();
    }

    protected void pickDate(By element, Date date) {
        driver.findElement(element)
                .sendKeys(formatDate(date) + "\n");
    }
}
