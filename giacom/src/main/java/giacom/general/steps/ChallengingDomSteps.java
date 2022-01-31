package giacom.general.steps;

import cucumber.api.java.en.Then;
import giacom.general.pages.ChallengingDomPage;
import giacom.settings.base.BaseTest;

import javax.inject.Inject;

public class ChallengingDomSteps extends BaseTest {

    // Injections

    @Inject
    private ChallengingDomPage challengingDomPage;

    // Step Definitions

    @Then("^User will be able verify that \"([^\"]*)\" in selected \"([^\"]*)\" and \"([^\"]*)\" is correct$")
    public void userWillBeAbleVerifyThatInSelectedAndIsCorrect(String value, String row, String columnName) {
        LOG.info("Verify that selected values are correct");
        LOG.info("Used values are:");
        LOG.info("Column name: " + columnName);
        LOG.info("Row number: " + row);
        LOG.info("Desired value on selected table position: " + value);
        challengingDomPage.checkTableValueIsCorrect(columnName, Integer.parseInt(row), value);
    }
}
