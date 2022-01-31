package giacom.general.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giacom.general.pages.InputsPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

import static giacom.settings.base.Constants.*;

public class InputsSteps extends BaseTest {

    // Injections

    @Inject
    private InputsPage inputsPage;

    // Steps Definitions

    @When("^User will fill \"([^\"]*)\" form and submit it$")
    public void userWillFillFormAndSubmitIt(String fillForm) {
        switch (fillForm) {
            case EMPTY -> {
                LOG.info("Try to send form without filling anything");
                inputsPage.checkMessageWasNotSent();
            }
            case WRONG_EMAIL -> {
                LOG.info("Fill everything with invalid email");
                inputsPage.fillFormWithInvalidEmail();
                inputsPage.checkMessageWasNotSent();
            }
            case ALL_CORRECT -> {
                LOG.info("Fill whole form correctly");
                inputsPage.fillFormWithValidData();
            }
            default -> throw new IllegalArgumentException("Illegal argument type: " + fillForm);
        }
    }

    @Then("^User will verify form was accepted$")
    public void userWillVerifyFormWasAccepted() {
        LOG.info("Verify form was sent");
        inputsPage.checkMessageWasSent();
    }
}
