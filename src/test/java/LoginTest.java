import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.ProfilePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private static String correctLogin = "storm-joy@mail.ru";
    private static String correctPassword = "123123";

    @Test
    public void loginCheckNegativeTests() {
        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.getDriver().get(baseUrl);

        //incorrect login/incorrect password
        authenticationPage.userSignIn("", "");
        assertTrue(authenticationPage.hasAuthenticationError(AuthenticationPage.errorEmailIsRequired), "Empty login has no error");

        //correct login/ incorrect password
        authenticationPage.userSignIn(correctLogin, "");
        //assertFalse(authenticationPage.hasLoginError(), "Empty password has login error");
        assertTrue(authenticationPage.hasAuthenticationError(AuthenticationPage.errorPasswordIsRequired), "Empty password has no error");

        //incorrect login/ correct password
        authenticationPage.userSignIn("", correctPassword);
        assertTrue(authenticationPage.hasAuthenticationError(AuthenticationPage.errorEmailIsRequired), "Wrong Login with correct password has no error");

        //enter login as correct password
        authenticationPage.userSignIn(correctPassword, correctPassword);
        assertTrue(authenticationPage.hasAuthenticationError(AuthenticationPage.errorInvalidEmail), "Login equals password has no error");

        //enter password as correct login
        authenticationPage.userSignIn(correctLogin, correctLogin);
        assertTrue(authenticationPage.hasAuthenticationError(AuthenticationPage.errorAuthenticationFailed), "Password equals login has no error");

        // check correct trim, of whitespaces
        authenticationPage.userSignIn("    " + correctLogin + "   ", correctPassword);
        ProfilePage profilePage = new ProfilePage(authenticationPage.getDriver());
        assertTrue(profilePage.isLoaded(), "Correct login with whitespaces is not allowed");
    }


    @Test
    public void loginWithCorrectCredentials() {
        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.getDriver().get(baseUrl);
        authenticationPage.setLogin(correctLogin);
        authenticationPage.setPassword(correctPassword);
        authenticationPage.userSignIn();
        //TODO check if errors
        ProfilePage profilePage = new ProfilePage(authenticationPage.getDriver());
        assertTrue(profilePage.isLoaded());
    }





}
