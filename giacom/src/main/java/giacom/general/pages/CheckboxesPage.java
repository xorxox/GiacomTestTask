package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class CheckboxesPage extends BasePage {

    // Web Elements

    @FindBy(xpath = "//div[@id='content']//h3[contains(text(),'Checkboxes')]")
    private WebElement checkboxesHeader;

    @FindBy(xpath = "//div[@id='content']//form[@id='checkboxes']/input[1]")
    private WebElement checkBoxOneInput;

    @FindBy(xpath = "//div[@id='content']//form[@id='checkboxes']/input[2]")
    private WebElement checkBoxTwoInput;

    // Page Objects

    public void checkboxesPageIsOpen() {
        checkIfElementExist(checkboxesHeader);
    }

    public boolean getCheckboxOneState() {
        return "true".equals(getElementAttributeValue(checkBoxOneInput, "checked"));
    }

    public boolean getCheckboxTwoState() {
        return "true".equals(getElementAttributeValue(checkBoxTwoInput, "checked"));
    }

    public void checkFirstCheckbox() {
        clickOnElement(checkBoxOneInput);
    }

    public void checkSecondCheckbox() {
        clickOnElement(checkBoxTwoInput);
    }

    public void reloadPage() {
        refreshPage();
        checkIfElementExist(checkboxesHeader);
    }
}
