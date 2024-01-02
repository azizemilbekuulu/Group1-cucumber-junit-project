package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Roman_SignupPage implements LoginPages {

    public Roman_SignupPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2/b")
    private WebElement enterAccInfoMessage;

    @FindBy(id = "id_gender1")
    private WebElement genderMale;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dayOfBirth;

    @FindBy(id = "months")
    private WebElement monthOfBirth;

    @FindBy(id = "years")
    private WebElement yearOfBirth;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1_Input;

    @FindBy(id = "address2")
    private WebElement address2_Input;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement selectCountry;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//button[.='Create Account']")
    private WebElement createAccountButton;

    public WebElement getGenderMale() {
        return genderMale;
    }

    public void selectDateOfBirth(int day, int month, int year) {
        var selectDay = new Select(dayOfBirth);
        selectDay.selectByValue(String.valueOf(day));
        var selectMonth = new Select(monthOfBirth);
        selectMonth.selectByValue(String.valueOf(month));
        var selectYear = new Select(yearOfBirth);
        selectYear.selectByValue(String.valueOf(year));
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getCheckbox(String checkbox) {
        WebElement targetCheckbox = null;
        if (checkbox.contains("newsletter"))
            targetCheckbox = newsletterCheckbox;
        else if (checkbox.contains("special offers"))
            targetCheckbox = specOffersCheckbox;

        return targetCheckbox;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getCompanyInput() {
        return companyInput;
    }

    public WebElement getAddress1_Input() {
        return address1_Input;
    }

    public WebElement getAddress2_Input() {
        return address2_Input;
    }

    public void selectCountry(String country) {
        var select = new Select(selectCountry);
        select.selectByValue(country);
    }

    public WebElement getStateInput() {
        return stateInput;
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getZipcodeInput() {
        return zipcodeInput;
    }

    public WebElement getPhoneNumberInput() {
        return phoneNumberInput;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    @Override
    public WebElement getMessage(String message) {
        if (message.equals("ENTER ACCOUNT INFORMATION"))
            return enterAccInfoMessage;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public WebElement getButton(String button) {
        WebElement targetButton = null;
        if (button.equals("Create Account"))
            targetButton = createAccountButton;

        return targetButton;
    }

    @Override
    public void closeAddIfPresent() {}

}
