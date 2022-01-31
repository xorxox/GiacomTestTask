package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class MultipleWindowsPage extends BasePage {

    // Web Elements

    @FindBy(xpath = "//div[@id='content']//h3[contains(text(),'Opening a new window')]")
    private WebElement multipleWindowsPageHeader;

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Click Here')]")
    private WebElement createNewWindowLink;

    @FindBy(xpath = "//h3[contains(text(),'New Window')]")
    private WebElement newWindowHeader;

    // Page Objects

    public void multipleWindowsPageIsOpen() {
        waitForElementToAppear(multipleWindowsPageHeader);
    }

    public void clickOnCreateNewWindowLink() {
        clickOnElement(createNewWindowLink);
    }

    public void newWindowIsSelected() {
        moveToTab(1);
        waitForElementToAppear(newWindowHeader);
    }

    public void closeNewlyCreatedWindow() {
        closeTab();
        moveToTab(0);
        waitForElementToAppear(multipleWindowsPageHeader);
    }
}
