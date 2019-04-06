package codinground.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import codinground.domain.SignIn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page {
    @FindBy(id = "SignIn")
    private WebElement signIn;

    @FindBy(id = "errors1")
    private WebElement errors1;

    @FindBy(id = "email")
    private WebElement userName;


    @FindBy(id = "password")
    private WebElement password;


    @FindBy(css = "signInButton")
    private WebElement signInButton;

    @FindBy(id = "trips")
    private WebElement trips;

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    public void signIn(SignIn signIn) {
        signInLink();
        switchtoModelWindow();
        enterText(signIn.getUserName(),userName);
        enterText(signIn.getPassword(),password);
        doSignIn();
    }

    public void signInLink() {
        signIn.click();
    }
    public String getErrorMsg() {
        return errors1.getText();
    }

    public boolean isErrorMsg(String errorMsg)   {
        return isElementcontains(getErrorMsg(), errorMsg ) ;
    }

    public  void enterText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);

    }
    public void doSignIn() {
        driver.findElement(By.id("signInButton")).click();
    }

    public  void switchtoModelWindow()
    {
        driver.switchTo().frame("modal_window");
    }
    public boolean isCheckTripLink() {
        return isElementPresent(trips);
    }

}
