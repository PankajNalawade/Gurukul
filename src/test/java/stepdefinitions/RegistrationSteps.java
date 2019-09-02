package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.HomePage;
import pageobjects.RegistrationPage;


public class RegistrationSteps {
    TestContext testContext;
    RegistrationPage registrationPage;
    HomePage homePage;

    public RegistrationSteps(TestContext context) {
        testContext = context;
        registrationPage = testContext.getPageObjectManager().getRegistrationPage();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^User is on registration page$")
    public void userIsOnRegistrationPage() {
        registrationPage.navigateToRegistrationPage();
    }

    @When("^user register with valid details$")
    public void userRegisterWithValidDetails() {
        homePage = registrationPage.performRegistration();
    }
}
