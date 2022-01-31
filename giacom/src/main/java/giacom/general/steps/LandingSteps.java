package giacom.general.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import giacom.general.pages.LandingPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

public class LandingSteps extends BaseTest {

    // Injections

    @Inject
    private LandingPage landingPage;

    // Steps Definitions

    @Then("^User is on landing page$")
    public void userIsOnLandingPage() throws Exception {
        landingPage.verifyLandingPageIsPresent();
    }

    @Given("^User will logout$")
    public void userWillLogout() {
        landingPage.logOutFromLandingPage();
    }
}
