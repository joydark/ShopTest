import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.ProfilePage;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class CreateAccountTest extends BaseTest {


    @Test
    public void createAccount() {
        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.getDriver().get(baseUrl);
        int random = new Random().nextInt();
        authenticationPage.createAccount("storm-joy" + random + "@example.com");
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        createAccountPage.setGender("female");
        createAccountPage.setCustomerFirstName("Test first name");
        createAccountPage.setCustomerLastName("Test last name");
        createAccountPage.setPassword("123123");
        createAccountPage.setDayOfBirthDay("1");
        createAccountPage.setMonthOfBirthDay("January");
        createAccountPage.setYearOfBirthday("2019");
        createAccountPage.setNewsletterSubscribe(true);
        createAccountPage.setSpecialOffersSubscribe(true);
        createAccountPage.setAddressFirstName("address First name");
        createAccountPage.setAddressLastName("address last name");
        createAccountPage.setCompany("test company");
        createAccountPage.setAddress("test page address");
        createAccountPage.setCity("test city");
        createAccountPage.setState("Arkansas");
        createAccountPage.setPostalCode("00000");
        createAccountPage.setCountry("United States");
        createAccountPage.setAdditionalInformation("test info");
        createAccountPage.setPhone("123");
        createAccountPage.setMobilePhone("123");
        createAccountPage.setAddressAlias("testAlias");
        createAccountPage.createAccount();
        ProfilePage profilePage = new ProfilePage(createAccountPage.getDriver());
        assertTrue(profilePage.isLoaded(), "Not successfully registered");
        profilePage.signOut();
    }

    @Test
    public void checkCreateAccountEmailTest() {
        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.getDriver().get(baseUrl);

        authenticationPage.createAccount("");
        assertTrue(authenticationPage.hasEmailError(AuthenticationPage.errorInvalidEmail), "Email can't be empty");

        authenticationPage.createAccount("onlytext");
        assertTrue(authenticationPage.hasEmailError(AuthenticationPage.errorInvalidEmail), "Email can't be without @");

        authenticationPage.createAccount("textwhithoutdomain@");
        assertTrue(authenticationPage.hasEmailError(AuthenticationPage.errorInvalidEmail), "Email can't be without site name");

        authenticationPage.createAccount("textwhithoutdomain@example");
        assertTrue(authenticationPage.hasEmailError(AuthenticationPage.errorInvalidEmail), "Email can't be without dot");

        authenticationPage.createAccount("textwhithoutdomain@example.");
        assertTrue(authenticationPage.hasEmailError(AuthenticationPage.errorInvalidEmail), "Email can't be without domain name");

        authenticationPage.createAccount("\"\"test\\test\"\"@example.com");
        assertTrue(authenticationPage.hasEmailError(AuthenticationPage.errorInvalidEmail), "Email can't be with \"");

        authenticationPage.createAccount("storm-joy@mail.ru");
        assertTrue(authenticationPage.hasEmailError(AuthenticationPage.errorEmailAlreadyRegistered), "Create account with already registred email");
    }


}
