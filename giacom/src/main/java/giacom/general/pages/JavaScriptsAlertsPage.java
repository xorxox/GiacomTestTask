package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

@PageObject
public class JavaScriptsAlertsPage extends BasePage {

    // Web Elements

    @FindBy(xpath = "//div[@id='content']//h3[contains(text(),'JavaScript Alerts')]")
    private WebElement javaScriptsAlertsHeader;

    @FindBy(xpath = "//div[@id='content']//button[contains(text(),'Click for JS Alert')]")
    private WebElement javaScriptsAlertsButton;

    @FindBy(xpath = "//div[@id='content']//button[contains(text(),'Click for JS Confirm')]")
    private WebElement javaScriptsConfirmButton;

    @FindBy(xpath = "//div[@id='content']//button[contains(text(),'Click for JS Prompt')]")
    private WebElement javaScriptsPromptButton;

    @FindBy(xpath = "//div[@id='content']//p[@id='result']")
    private WebElement results;

    // Page Objects

    public void javaScriptsAlertsPageIsOpen() {
        waitForElementToAppear(javaScriptsAlertsHeader);
    }

    public void clickOnJavaScriptAlertButton() {
        clickOnElement(javaScriptsAlertsButton);
    }

    public void clickOnJavaScriptConfirmButton() {
        clickOnElement(javaScriptsConfirmButton);
    }

    public void clickOnJavaScriptPromptButton() {
        clickOnElement(javaScriptsPromptButton);
    }

    public void closeJsAlert() {
        closeJavaScriptAlertOk();
    }

    public void closeJSConfirm() {
        closeJavaScriptAlertCancel();
    }

    public void verifyJsPromptAlert() {
        String jsPromptAlertText = getJavaScriptAlertText();
        assertEquals("I am a JS prompt", jsPromptAlertText);
    }

    public void writeIntoAlert(String inputValue) {
        writeIntoJavaScriptAlert(inputValue);
    }

    public void validResultsForAlert() throws Exception {
        String actualText = getElementText(results);
        assertEquals("You successfuly clicked an alert", actualText);
    }

    public void validResultsForConfirm() throws Exception {
        String actualText = getElementText(results);
        assertEquals("You clicked: Cancel", actualText);
    }

    public void validResultsForPrompt() throws Exception {
        String actualText = getElementText(results);
        assertEquals("You entered: check1", actualText);
    }
}
