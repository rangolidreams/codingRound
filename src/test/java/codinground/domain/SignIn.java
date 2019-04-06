package codinground.domain;

import java.util.Random;

public class SignIn
{
    private final String userName;
    private final String password;

    public SignIn(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static SignIn getSignIn() {
        return new SignIn(
                System.getProperty("user.name"),
                System.getProperty("user.password"));
    }

    public static SignIn withWrongPassword() {
        SignIn properSignIn = getSignIn();
        return new SignIn(properSignIn.getUserName(), "invalid password");
    }
}
