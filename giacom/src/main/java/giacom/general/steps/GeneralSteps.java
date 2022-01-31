package giacom.general.steps;

import cucumber.api.java.en.Given;
import giacom.general.pages.*;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

import static giacom.settings.base.Constants.*;
import static giacom.settings.base.Topology.PASSWORD;
import static giacom.settings.base.Topology.USERNAME;


public class GeneralSteps extends BaseTest {

    // Injections

    @Inject
    private LoginSteps loginSteps;

    @Inject
    private LandingPage landingPage;

    @Inject
    private ChallengingDomPage challengingDomPage;

    @Inject
    private CheckboxesPage checkboxesPage;

    @Inject
    private EntryAdPage entryAdPage;

    @Inject
    private InputsPage inputsPage;

    @Inject
    private JavaScriptsAlertsPage javaScriptsAlertsPage;

    @Inject
    private MultipleWindowsPage multipleWindowsPage;

    // Step Definitions

    @Given("^User will login and is on landing page$")
    public void userWillLoginAndIsOnLandingPage() throws Exception {
        loginSteps.userOpenLoginPage();
        loginSteps.userLoginWithValidLoginCredentialsLoginPassword(USERNAME, PASSWORD);
        landingPage.verifyLandingPageIsPresent();
    }

    @Given("^User will open \"([^\"]*)\" page$")
    public void userWillOpenPage(String pageType) {
        switch (pageType) {
            case CHALLENGING_DOM -> {
                landingPage.openChallengingDomPage();
                challengingDomPage.challengingDomPageIsOpen();
            }
            case CHECKBOXES -> {
                landingPage.openCheckboxesPage();
                checkboxesPage.checkboxesPageIsOpen();
            }
            case ENTRY_AD -> {
                landingPage.openEntryAdPage();
                entryAdPage.entryAdPageIsOpen();
            }
            case INPUTS -> {
                landingPage.openInputsPage();
                inputsPage.inputsPageIsOpen();
            }
            case JAVASCRIPT_ALERTS -> {
                landingPage.openJavaScriptAlertPage();
                javaScriptsAlertsPage.javaScriptsAlertsPageIsOpen();
            }
            case LARGE_AND_DEEP_DOM -> {
                landingPage.openLargeAndDeepDomPage();
            }
            case MULTIPLE_WINDOWS -> {
                landingPage.openMultipleWindowsPage();
                multipleWindowsPage.multipleWindowsPageIsOpen();
            }
            default -> throw new IllegalArgumentException("Illegal argument type: " + pageType);
        }
    }
}
