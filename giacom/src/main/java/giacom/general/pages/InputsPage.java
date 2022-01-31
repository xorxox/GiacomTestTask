package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@PageObject
public class InputsPage extends BasePage {

    // Web Elements

    @FindBy(xpath = "//div[@id='content']//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='content']//input[@id='r1']")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//div[@id='content']//input[@id='r2']")
    private WebElement noRadioButton;

    @FindBy(xpath = "//div[@id='content']//input[@id='n1']")
    private WebElement ageInputField;

    @FindBy(xpath = "//div[@id='content']//input[@id='t1']")
    private WebElement fruitInputField;

    @FindBy(xpath = "//div[@id='content']//datalist[@id='l1']/option")
    private WebElement fruitDataList;

    @FindBy(xpath = "//div[@id='content']//input[@id='t2']")
    private WebElement emailInputField;

    @FindBy(xpath = "//div[@id='content']//input[@id='t3']")
    private WebElement messageTextArea;

    // Page Objects

    public void inputsPageIsOpen() {
        waitForElementToAppear(submitButton);
    }

    public void selectDriverLicenceYes() {
        clickOnElement(yesRadioButton);
    }

    public void fillAge(int age) {
        fillElement(ageInputField, String.valueOf(age));
    }

    public void fillFavouriteFruit(String fruit) {
        fillElement(fruitInputField, fruit);
    }

    public void fillEmailAddress(String email) {
        fillElement(emailInputField, email);
    }

    public void pressSubmitButton() {
        clickOnElement(submitButton);
    }

    public void checkMessageWasNotSent() {
        String getUrlBeforeSubmit = getCurrentUrl();
        pressSubmitButton();
        String getUrlAfterSubmit = getCurrentUrl();

        assertEquals(getUrlBeforeSubmit, getUrlAfterSubmit);
    }

    public void fillFormWithInvalidEmail() {
        selectDriverLicenceYes();
        fillAge(39);
        fillFavouriteFruit("Apple");
        fillEmailAddress("abcdefg");
    }

    public void fillFormWithValidData() {
        selectDriverLicenceYes();
        fillAge(39);
        fillFavouriteFruit("Apple");
        fillEmailAddress("x@y.com");
    }

    public void checkMessageWasSent() {
        String getUrlBeforeSubmit = getCurrentUrl();
        pressSubmitButton();
        String getUrlAfterSubmit = getCurrentUrl();

        assertNotEquals(getUrlBeforeSubmit, getUrlAfterSubmit);
    }
}
