package giacom.general.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giacom.general.pages.InputsPage;

import javax.inject.Inject;

import static giacom.settings.base.Constants.*;

public class InputsSteps {

    // Injections

    @Inject
    private InputsPage inputsPage;

    // Steps Definitions

    @When("^User will fill \"([^\"]*)\" form and submit it$")
    public void userWillFillFormAndSubmitIt(String fillForm) {
        switch (fillForm) {
            case EMPTY -> inputsPage.checkMessageWasNotSent();
            case WRONG_EMAIL -> {
                inputsPage.fillFormWithInvalidEmail();
                inputsPage.checkMessageWasNotSent();
            }
            case ALL_CORRECT -> inputsPage.fillFormWithValidData();
            default -> throw new IllegalArgumentException("Illegal argument type: " + fillForm);
        }
    }

    @Then("^User will verify form was accepted$")
    public void userWillVerifyFormWasAccepted() {
        inputsPage.checkMessageWasSent();
    }
}
