package giacom.general.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giacom.general.pages.JavaScriptsAlertsPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

import static giacom.settings.base.Constants.*;

public class JavaScriptAlertsSteps extends BaseTest {

    // Injections

    @Inject
    private JavaScriptsAlertsPage javaScriptsAlertsPage;

    // Step Definitions

    @When("^User will click on \"([^\"]*)\" button$")
    public void userWillClickOnButton(String buttonType) {
        LOG.info("Click on " + buttonType + " button");
        switch (buttonType) {
            case CLICK_FOR_JS_ALERT -> javaScriptsAlertsPage.clickOnJavaScriptAlertButton();
            case CLICK_FOR_JS_CONFIRM -> javaScriptsAlertsPage.clickOnJavaScriptConfirmButton();
            case CLICK_FOR_JS_PROMPT -> javaScriptsAlertsPage.clickOnJavaScriptPromptButton();
            default -> throw new IllegalArgumentException("Illegal argument type: " + buttonType);
        }
    }

    @And("^User is able to close \"([^\"]*)\" alert$")
    public void userIsAbleToCloseAlert(String alertOperationType) {
        LOG.info("User is able to close " + alertOperationType + " alert operation");
        switch (alertOperationType) {
            case ALERT -> javaScriptsAlertsPage.closeJsAlert();
            case CONFIRM -> javaScriptsAlertsPage.closeJSConfirm();
            default -> throw new IllegalArgumentException("Illegal argument type: " + alertOperationType);
        }
    }

    @And("^User can see \"([^\"]*)\" result$")
    public void userCanSeeResult(String resultType) throws Exception {
        LOG.info("Verify user see result for " + resultType + " result type");
        switch (resultType) {
            case SUCCESSFUL -> javaScriptsAlertsPage.validResultsForAlert();
            case CLICKED -> javaScriptsAlertsPage.validResultsForConfirm();
            case ENTERED -> javaScriptsAlertsPage.validResultsForPrompt();
            default -> throw new IllegalArgumentException("Illegal argument type: " + resultType);
        }
    }

    @Then("^User is able to verify alert$")
    public void userIsAbleToVerifyAlert() {
        LOG.info("Verify alert is present");
        javaScriptsAlertsPage.verifyJsPromptAlert();
    }

    @And("^User is able to fill alert with \"([^\"]*)\" value$")
    public void userIsAbleToFillAlertWithValue(String value) {
        LOG.info("Fill JS Alert with text, text used: " + value);
        javaScriptsAlertsPage.writeIntoAlert(value);
    }
}
