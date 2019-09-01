package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePage {

    public static String errorEmailIsRequired = "An email address required.";
    public static String errorPasswordIsRequired = "Password is required.";
    public static String errorInvalidEmail = "Invalid email address.";
    public static String errorAuthenticationFailed = "Authentication failed.";
    public static String errorEmailAlreadyRegistered = "An account using this email address has already been registered.";


    @FindBy(id = "email_create")
    private WebElement createAccountEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email")
    private WebElement login;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(css = ".lost_password a")
    private WebElement forgotPasswordLink;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(className = "alert-danger")
    private WebElement errorAlert;

    @FindBy(id = "create_account_error")
    private WebElement emailError;


    public void createAccount(String email) {
        setEmail(email);
        createAccountButton.click();
    }

    public void setEmail(String email) {
        this.createAccountEmail.clear();
        this.createAccountEmail.sendKeys(email);
    }

    public void setLogin(String login) {
        this.login.clear();
        this.login.sendKeys(login);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void userSignIn(String login, String password) {
        setLogin(login);
        setPassword(password);
        userSignIn();
    }

    public void userSignIn() {
        this.submitLogin.click();
    }


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasAuthenticationError(String errorText) {
        WebElement error = null;
        try {
            error = driver.findElement(By.xpath("//*[contains(text(), '" + errorText + "')]"));
        } catch (NoSuchElementException e) {
        }
        return error != null;
    }

    public Boolean hasEmailError(String emailErrorText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("create_account_error")));
        return this.emailError.getText().contains(emailErrorText);
    }


}
