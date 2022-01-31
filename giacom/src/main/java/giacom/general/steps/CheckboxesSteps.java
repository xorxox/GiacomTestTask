package giacom.general.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giacom.general.pages.CheckboxesPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

import static org.junit.Assert.fail;

public class CheckboxesSteps extends BaseTest {

    // injections

    @Inject
    private CheckboxesPage checkboxesPage;

    // Steps Definitions

    @When("^Checkbox (\\d+) is \"([^\"]*)\"$")
    public void checkboxIs(int checkboxNumber, String state) {
        LOG.info("Check state of checkbox " + checkboxNumber + ", state should be " + state);
        switch (checkboxNumber) {
            case 1 -> {
                if ("checked".equals(state)) {
                    if (!checkboxesPage.getCheckboxOneState()) fail();
                } else if ("unchecked".equals(state)) {
                    if (checkboxesPage.getCheckboxOneState()) fail();
                }
            }
            case 2 -> {
                if ("checked".equals(state)) {
                    if (!checkboxesPage.getCheckboxTwoState()) fail();
                } else if ("unchecked".equals(state)) {
                    if (checkboxesPage.getCheckboxTwoState()) fail();
                }
            }
            default -> throw new IllegalArgumentException("Illegal argument type: " + checkboxNumber);
        }
    }

    @Then("^Set checkbox (\\d+) to \"([^\"]*)\"$")
    public void setCheckboxTo(int checkboxNumber, String state) {
        LOG.info("Set state of checkbox " + checkboxNumber + " to state " + state);
        switch (checkboxNumber) {
            case 1 -> {
                checkboxesPage.checkFirstCheckbox();
                if ("checked".equals(state)) {
                    if (!checkboxesPage.getCheckboxOneState()) fail();
                } else if ("unchecked".equals(state)) {
                    if (checkboxesPage.getCheckboxOneState()) fail();
                }
            }
            case 2 -> {
                checkboxesPage.checkSecondCheckbox();
                if ("checked".equals(state)) {
                    if (!checkboxesPage.getCheckboxTwoState()) fail();
                } else if ("unchecked".equals(state)) {
                    if (checkboxesPage.getCheckboxTwoState()) fail();
                }
            }
            default -> throw new IllegalArgumentException("Illegal argument type: " + checkboxNumber);
        }
    }

    @And("^Reload page and verify default state is set$")
    public void reloadPageAndVerifyDefaultStateIsSet() {
        LOG.info("Verify checkboxes are set to default correct values");
        checkboxesPage.reloadPage();
        checkboxIs(1, "unchecked");
        checkboxIs(2, "checked");
    }
}
