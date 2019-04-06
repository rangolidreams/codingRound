package codinground.tests;

import codinground.BaseTest;
import codinground.domain.SignIn;
import codinground.page.HomePage;
import codinground.page.SignInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {
    @Test
    public void testThatSignInFailure() {
        HomePage homePage = HomePage.moveToHomePage(driver);
        SignInPage signInPage= homePage.goToYourTrips();
        SignIn properSign = SignIn.withWrongPassword();
        signInPage.signIn(new SignIn(properSign.getUserName(), properSign.getPassword()));
        assertEquals(signInPage.getErrorMsg(), "There were errors in your submission\n" +
                "Your account password cannot start or end with a space.");
    }

    @Test
    public void testThatSignInSuccess() {
        HomePage homePage = HomePage.moveToHomePage(driver);
        SignInPage signInPage= homePage.goToYourTrips();
        SignIn properSign = SignIn.getSignIn();
        signInPage.signIn(new SignIn(properSign.getUserName(), properSign.getPassword()));
        assertTrue(signInPage.isCheckTripLink());
    }
}
