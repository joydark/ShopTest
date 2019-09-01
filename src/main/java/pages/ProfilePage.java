package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(className = "logout")
    private WebElement logout;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isLoaded() {
        return this.logout.isDisplayed();
    }

    public void signOut() {
        this.logout.click();
    }
}
