package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.WelcomePage;

public class AuthorizationSteps {
    TestContext testContext;
    LoginPage loginPage;
    HomePage homePage;
    WelcomePage welcomePage;

    public AuthorizationSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @When("^User logged in with valid login id and password$")
    public void userLoggedWithValidDetails() {
        homePage = loginPage.login();
    }

    @When("^User log off from the application$")
    public void userLogOffFromApplication() {
        welcomePage = homePage.logoff();
    }

    @Then("^User is on homepage$")
    public void userIsOnHomepage() {
        homePage.userIsOnHomePage();
    }

    @Then("^User is on welcome page$")
    public void userIsOnWelcomePage() {
        welcomePage.verifyUserOnWelcomePage();
    }
}
