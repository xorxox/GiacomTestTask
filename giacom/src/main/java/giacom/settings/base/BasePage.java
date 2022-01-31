package giacom.settings.base;

import giacom.settings.configuration.PageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runners.model.InitializationError;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Inject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@PageObject
public abstract class BasePage {

    protected static final Logger LOG = LogManager.getLogger(BasePage.class);

    private static final int WAIT_TIME = 15;

    // Injections

    @Inject
    protected WebDriver driver;

    // Web Driver methods

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Element operations

    protected void clickOnElement(WebElement element) {
        clickOnElement(element, WAIT_TIME);
    }

    protected String getElementText(WebElement element) throws Exception {
        checkIfElementExist(element);

        long start = System.currentTimeMillis();
        long end = start + 30 * 1000;

        while ("".equals(element.getText())) {
            Thread.sleep(500);
            if (System.currentTimeMillis() > end) {
                throw new InitializationError("It was not possible to get value for desired variable in time.");
            }
        }

        return element.getText();
    }

    protected String getElementAttributeValue(WebElement element, String attributeName) {
        return getElementAttribute(element, attributeName, WAIT_TIME);
    }

    // Verify Element methods

    protected void checkIfElementExist(WebElement element) {
        verifyExisting(element, WAIT_TIME);
        verifyVisibility(element, WAIT_TIME);
    }

    // Wait Until methods

    protected void waitForElementToAppear(WebElement element) {
        verifyExisting(element, WAIT_TIME);
        verifyVisibility(element, WAIT_TIME);
    }

    protected void clickOnWebElementUntilClickable(WebElement webElement) {
        await()
                .atMost(Duration.ofSeconds(20))
                .pollDelay(Duration.ofMillis(500))
                .pollInterval(Duration.ofMillis(500))
                .until(() -> checkIfElementExistAndClickBoolean(webElement));
    }

    // Fill Element methods

    protected void fillElement(WebElement element, String input) {
        fillElement(element, input, WAIT_TIME);
    }

    // Table Operations methods

    protected String getValueFromTable(String tableRowXpath, int rowNumber, String usedRowElement, int columnNumber) {
        WebElement element = driver.findElement(By.xpath(tableRowXpath + "[" + rowNumber + "]/" + usedRowElement + "[" + columnNumber + "]"));
        verifyExisting(element, WAIT_TIME);
        verifyVisibility(element, WAIT_TIME);
        return element.getText();
    }

    // Tab methods

    protected void moveToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        LOG.info("Tabs size: " + tabs.size());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    protected void closeTab() {
        driver.close();
    }

    // Alerts methods

    protected void closeJavaScriptAlertOk() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    protected void closeJavaScriptAlertCancel() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    protected String getJavaScriptAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    protected void writeIntoJavaScriptAlert(String inputValue) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(inputValue);
        alert.accept();
    }

    // Auxiliary methods

    private void clickOnElement(WebElement element, long waitTime) {
        verifyExisting(element, waitTime);
        verifyVisibility(element, waitTime);
        verifyClickable(element, waitTime);

        element.click();
    }

    private String getElementAttribute(WebElement element, String attributeName, long waitTime) {
        verifyExisting(element, waitTime);
        verifyVisibility(element, waitTime);
        return element.getAttribute(attributeName);
    }

    private void verifyExisting(WebElement element, long waitTime) {
        WebDriverWait waitExist = new WebDriverWait(driver, waitTime);
        waitExist.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
    }

    private void verifyVisibility(WebElement element, long waitTime) {
        WebDriverWait waitVisible = new WebDriverWait(driver, waitTime);
        waitVisible.until(visibilityOf(element));
    }

    private void verifyClickable(WebElement element, long waitTime) {
        WebDriverWait waitClickable = new WebDriverWait(driver, waitTime);
        waitClickable.until(elementToBeClickable(element));
    }

    private void fillElement(WebElement element, String input, long waitTime) {
        verifyExisting(element, waitTime);
        verifyVisibility(element, waitTime);

        sendKeysElement(element, input);
    }

    private void sendKeysElement(WebElement element, String SendKeys) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        element.sendKeys(SendKeys);
    }

    private boolean checkIfElementExistAndClickBoolean(WebElement element) {
        try {
            verifyExisting(element, WAIT_TIME);
            verifyVisibility(element, WAIT_TIME);
            verifyClickable(element, WAIT_TIME);
            clickOnElement(element, WAIT_TIME);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
