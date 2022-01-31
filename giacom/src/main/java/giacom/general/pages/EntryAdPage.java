package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.fail;

@PageObject
public class EntryAdPage extends BasePage {

    // Web Element

    @FindBy(xpath = "//div[@id='modal']//p[contains(text(),'Close')]//parent::div")
    private WebElement modalWindowCloseLink;

    @FindBy(xpath = "//div[@id='content']//select[@id='dropdown']")
    private WebElement optionDropDown;

    // Page Objects

    public void entryAdPageIsOpen() {
        waitForElementToAppear(modalWindowCloseLink);
    }

    public void closeModalWindow() {
        clickOnWebElementUntilClickable(modalWindowCloseLink);
        clickOnElement(optionDropDown);
    }
}
