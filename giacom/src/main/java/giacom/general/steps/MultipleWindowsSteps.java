package giacom.general.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giacom.general.pages.MultipleWindowsPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

public class MultipleWindowsSteps extends BaseTest {

    // Injections

    @Inject
    private MultipleWindowsPage multipleWindowsPage;

    // Steps Definitions

    @When("^User will click on \"Click Here\" link$")
    public void userWillClickOnLink() {
        LOG.info("Create new browser tab");
        multipleWindowsPage.clickOnCreateNewWindowLink();
    }

    @And("^New window with text \"New Window\" is created$")
    public void newWindowWithTextIsCreated() {
        LOG.info("Verify new browser tab is selected");
        multipleWindowsPage.newWindowIsSelected();
    }

    @Then("^User can close window and focus on windows page$")
    public void userCanCloseWindowAndFocusOnWindowsPage() {
        LOG.info("Close new browser tab");
        multipleWindowsPage.closeNewlyCreatedWindow();
    }
}
