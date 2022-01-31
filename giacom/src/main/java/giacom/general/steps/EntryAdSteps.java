package giacom.general.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giacom.general.pages.EntryAdPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

public class EntryAdSteps extends BaseTest {

    // Injections

    @Inject
    private EntryAdPage entryAdPage;

    // Steps Definitions

    @Then("^User will close modal window$")
    public void userWillCloseModalWindow() {
        LOG.info("Close modal window");
        entryAdPage.closeModalWindow();
    }
}
