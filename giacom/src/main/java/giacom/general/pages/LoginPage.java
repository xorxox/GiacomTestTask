package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.fail;

@PageObject
public class LoginPage extends BasePage {

    // Web Elements

    @FindBy(xpath = "//div[@id='content']//h2[contains(text(),'Login Page')]")
    private WebElement loginPageHeader;

    @FindBy(xpath = "//form[@id='login']//input[@id='username']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//div[@id='content']//input[@id='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//div[@id='content']//button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement loginPageMessage;

    // Page Objects

    public void openLoginPage(String url) {
        driver.get(url);

        waitForElementToAppear(loginPageHeader);
    }

    public void login(String username, String password) {
        fillElement(usernameInputField, username);
        fillElement(passwordInputField, password);
        clickOnElement(loginButton);
    }

    public void verifyLoginPageIsPresent() throws Exception {
        waitForElementToAppear(loginPageHeader);
        waitForElementToAppear(loginPageMessage);
        String infoMessageContent = getElementText(loginPageMessage);
        if (!infoMessageContent.contains("You logged out of the secure area!")) fail();
    }

    public void verifyItIsNotPossibleToAccessLandingPage(String url) throws Exception {
        driver.get(url);
        waitForElementToAppear(loginPageHeader);
        waitForElementToAppear(loginPageMessage);
        String infoMessageContent = getElementText(loginPageMessage);
        if (!infoMessageContent.contains("You must login to view the secure area!")) fail();
    }
}
