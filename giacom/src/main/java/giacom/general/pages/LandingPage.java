package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.fail;

@PageObject
public class LandingPage extends BasePage {

    // Web Elements

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement loginMessage;

    @FindBy(xpath = "//div[@id='flash']/a")
    private WebElement loginMessageCloseCross;

    @FindBy(xpath = "//div[@id='content']/a")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Challenging DOM')]")
    private WebElement challengingDomLink;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Checkboxes')]")
    private WebElement checkboxesLink;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Entry Ad')]")
    private WebElement entryAdLink;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Inputs')]")
    private WebElement inputsLink;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'JavaScript Alerts')]")
    private WebElement javascriptAlertsLink;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Large & Deep DOM')]")
    private WebElement largeAndDeepDomLink;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Multiple Windows')]")
    private WebElement multipleWindowsLink;

    // Page Objects

    public void verifyLandingPageIsPresent() throws Exception {
        waitForElementToAppear(loginMessage);
        String infoMessageContent = getElementText(loginMessage);
        if (!infoMessageContent.contains("You logged into a secure area!")) fail();
    }

    public void logOutFromLandingPage() {
        clickOnElement(logoutButton);
    }

    public void openChallengingDomPage() {
        clickOnElement(challengingDomLink);
    }

    public void openCheckboxesPage() {
        clickOnElement(checkboxesLink);
    }

    public void openEntryAdPage() {
        clickOnElement(entryAdLink);
    }

    public void openInputsPage() {
        clickOnElement(inputsLink);
    }

    public void openJavaScriptAlertPage() {
        clickOnElement(javascriptAlertsLink);
    }

    public void openLargeAndDeepDomPage() {
        clickOnElement(largeAndDeepDomLink);
    }

    public void openMultipleWindowsPage() {
        clickOnElement(multipleWindowsLink);
    }
}
