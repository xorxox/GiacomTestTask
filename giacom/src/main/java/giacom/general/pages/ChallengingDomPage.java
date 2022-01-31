package giacom.general.pages;

import giacom.settings.base.BasePage;
import giacom.settings.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

@PageObject
public class ChallengingDomPage extends BasePage {

    // Web Elements

    @FindBy(xpath = "//div[@id='content']//h3[contains(text(),'Challenging DOM')]")
    private WebElement challengingDomHeader;

    @FindBy(xpath = "//div[@id='content']//table/thead/tr/th")
    private List<WebElement> listOfTableHeaders;

    // Page Objects

    public void challengingDomPageIsOpen() {
        waitForElementToAppear(challengingDomHeader);
    }

    public void checkTableValueIsCorrect(String nameOfColumn, int rowNumber, String expectedValue) {
        int columnNumber = 0;

        for (WebElement element : listOfTableHeaders) {
            columnNumber += 1;
            if (element.getText().contains(nameOfColumn)) break;
        }

        LOG.info("Column name number is " + columnNumber);

        String valueFromTable = getValueFromTable("//div[@id='content']//table/tbody/tr", rowNumber, "td", columnNumber);
        LOG.info("Selected value from the table is " + valueFromTable);
        assertEquals(expectedValue, valueFromTable);
    }
}
