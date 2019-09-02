package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePage;
import pageobjects.UserSettingsPage;

public class UserInformationUpdateSteps {
    TestContext testContext;
    HomePage homePage;
    UserSettingsPage userSettingsPage;

    public UserInformationUpdateSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        userSettingsPage = testContext.getPageObjectManager().getUserSettingsPage();
    }

    @When("^User go to user settings$")
    public void userGoToUserSettings() {
        userSettingsPage = homePage.goToUserSettingPage();
    }

    @And("^User update account information$")
    public void userUpdateAccountInformation() {
        userSettingsPage.updateUserAccountInformation();
    }

    @Then("^User account information updated successfully$")
    public void verifyUserInformationUpdate() {
        userSettingsPage.verifySuccessfulUserInfoUpdate();
    }
}
