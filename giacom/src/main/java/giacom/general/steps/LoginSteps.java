package giacom.general.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giacom.general.pages.LoginPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

import static giacom.settings.base.Topology.TEST_ENVIRONMENT_URL;
import static giacom.settings.base.Topology.TEST_ENVIRONMENT_URL_LOGGED_IN;

public class LoginSteps extends BaseTest {

    // Injections

    @Inject
    private LoginPage loginPage;

    // Step Definitions

    @Given("^User open login page$")
    public void userOpenLoginPage() {
        LOG.info("Open login page URL");
        loginPage.openLoginPage(TEST_ENVIRONMENT_URL);
    }

    @When("^User login with valid login credentials \\(login: \"([^\"]*)\", password: \"([^\"]*)\"\\)$")
    public void userLoginWithValidLoginCredentialsLoginPassword(String username, String password) {
        LOG.info("Login into website");
        loginPage.login(username, password);
    }

    @When("^User will be on login page$")
    public void userWillBeOnLoginPage() throws Exception {
        LOG.info("Login page is loading");
        loginPage.verifyLoginPageIsPresent();
    }

    @Then("^User cannot access landing page$")
    public void userCannotAccessLandingPage() throws Exception {
        LOG.info("Verify it is not possible to get on landing page without logging");
        loginPage.verifyItIsNotPossibleToAccessLandingPage(TEST_ENVIRONMENT_URL_LOGGED_IN);
    }
}
