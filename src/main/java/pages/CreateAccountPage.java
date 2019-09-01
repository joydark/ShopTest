package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.Date;

public class CreateAccountPage extends BasePage {
    protected static String errorPhoneRequired = "You; must register at least one phone number.";
    protected static String errorLastnameRequired = "lastname is required.";
    protected static String errorFirstnameRequired = "firstname is required.";
    protected static String errorPasswordRequired = "passwd is required.";
    protected static String errorAddressRequired = "address1 is required.";
    protected static String errorCityRequired = "city is required.";
    protected static String errorPostalCodeRequired = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
    protected static String errorCountryRequired = "This country requires you to choose a State.";

    @FindBy(id = "uniform-id_gender1")
    private WebElement genderMale;

    @FindBy(id = "uniform-id_gender2")
    private WebElement genderFemale;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;


    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement dayOfBirthDay;

    @FindBy(id = "months")
    private WebElement monthOfBirthDay;

    @FindBy(id = "years")
    private WebElement yearOfBirthday;

    @FindBy(id = "uniform-newsletter")
    private WebElement newsletterSubscribe;


    @FindBy(id = "uniform-optin")
    private WebElement specialOffersSubscribe;


    @FindBy(id = "firstname")
    private WebElement addressFirstName;

    @FindBy(id = "lastname")
    private WebElement addressLastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "address2")
    private WebElement addressAdditional;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postalCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "other")
    private WebElement additionalInformation;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement addressAlias;


    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }


    public void setGender(String gender) {
        if (gender.equals("Male")) {
            this.genderMale.click();
        } else {
            this.genderFemale.click();
        }
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName.clear();
        this.customerFirstName.sendKeys(customerFirstName);
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName.clear();
        this.customerLastName.sendKeys(customerLastName);
    }

    public void setEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void setBirthday(Date date) {

    }

    public void setDayOfBirthDay(String dayOfBirthDay) {
        Select select = new Select(this.dayOfBirthDay);
        select.selectByValue(dayOfBirthDay);
    }

    //todo fix &nbsp; problem
    public void setMonthOfBirthDay(String monthOfBirthDay) {
        Select select = new Select(this.monthOfBirthDay);
        select.selectByVisibleText(monthOfBirthDay + " ");
    }

    public void setYearOfBirthday(String yearOfBirthday) {
        Select select = new Select(this.yearOfBirthday);
        select.selectByValue(yearOfBirthday);
    }

    public void setNewsletterSubscribe(Boolean subscribe) {
        if (subscribe && !this.newsletterSubscribe.isSelected())
            this.newsletterSubscribe.click();
        if (!subscribe && this.newsletterSubscribe.isSelected())
            this.newsletterSubscribe.click();
    }

    public void setSpecialOffersSubscribe(Boolean specialOffersSubscribe) {
        if (specialOffersSubscribe && !this.specialOffersSubscribe.isSelected())
            this.specialOffersSubscribe.click();
        if (!specialOffersSubscribe && this.specialOffersSubscribe.isSelected())
            this.specialOffersSubscribe.click();
    }

    public void setAddressFirstName(String addressFirstName) {
        this.addressFirstName.clear();
        this.addressFirstName.sendKeys(addressFirstName);
    }

    public void setAddressLastName(String addressLastName) {
        this.addressLastName.clear();
        this.addressLastName.sendKeys(addressLastName);
    }

    public void setCompany(String company) {
        this.company.clear();
        this.company.sendKeys(company);
    }

    public void setAddress(String address) {
        this.address.clear();
        this.address.sendKeys(address);
    }

    public void setAddressAdditional(String addressAdditional) {
        this.addressAdditional.clear();
        this.addressAdditional.sendKeys(addressAdditional);
    }

    public void setCity(String city) {
        this.city.clear();
        this.city.sendKeys(city);
    }

    public void setState(String state) {
        Select select = new Select(this.state);
        select.selectByVisibleText(state);
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.clear();
        this.postalCode.sendKeys(postalCode);
    }

    public void setCountry(String country) {
        Select select = new Select(this.country);
        select.selectByVisibleText(country);
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation.clear();
        this.additionalInformation.sendKeys(additionalInformation);
    }

    public void setPhone(String phone) {
        this.phone.clear();
        this.phone.sendKeys(phone);
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone.clear();
        this.mobilePhone.sendKeys(mobilePhone);
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias.clear();
        this.addressAlias.sendKeys(addressAlias);
    }

    public void createAccount() {
        this.submitAccount.click();
        //return new ProfilePage(getDriver());
    }

    public void hasErrors() {
        driver.findElement(By.xpath("//*[contains(text(), 'firstname')]"));
    }

}
