import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.ProfilePage;
import java.util.Random;
import static org.testng.Assert.assertTrue;

public class CreateAccountTest extends BaseTest {

    @Test
    public void checkCreateAccountEmailTest() {
        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.getDriver().get(baseUrl);
        authenticationPage.setEmail("");
        authenticationPage.clickCreateAccountButton();
        assertTrue(authenticationPage.hasAuthenticationError(AuthenticationPage.errorInvalidEmail), "Email can't be empty");
    }

    @Test
    public void createAccount() throws InterruptedException {
        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        authenticationPage.getDriver().get(baseUrl);
        int random = new Random().nextInt();
        CreateAccountPage createAccountPage = authenticationPage.createAccount("storm-joy" + random + "@example.com");
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
        assertTrue(profilePage.isLoaded());
    }


}
