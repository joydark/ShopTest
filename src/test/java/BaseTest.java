import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

abstract public class BaseTest {
    public String baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite() {
        if (null != driver) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
