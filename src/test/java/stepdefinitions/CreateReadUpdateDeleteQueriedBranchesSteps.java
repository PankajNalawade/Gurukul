package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.BranchHomePage;
import pageobjects.HomePage;

public class CreateReadUpdateDeleteQueriedBranchesSteps {

    TestContext testContext;
    HomePage homePage;
    BranchHomePage branchHomePage;

    public CreateReadUpdateDeleteQueriedBranchesSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        branchHomePage = testContext.getPageObjectManager().getBranchHomePage();
    }

    @When("^User navigate to Branch$")
    public void userNavigateToBranch() {
        branchHomePage = homePage.goToBranchPage();
    }

    @And("^User search existing branch$")
    public void userSearchExistingBranch() {
        branchHomePage.searchedExistingBranch();
    }

    @And("^User create new branch$")
    public void userCreateNewBranch() {
        branchHomePage.createNewbranch();
    }

    @And("^User view existing branch$")
    public void userViewExistingBranch() {
        branchHomePage.OpenExistingBranch();
    }

    @And("^User edit existing branch$")
    public void userEditExistingBranch() {
        branchHomePage.updateExistingBranch();
    }

    @And("^User delete existing branch$")
    public void userDeleteExistingBranch() {
        branchHomePage.deleteExistingBranch();
    }

    @Then("^User can see only that branch in branches$")
    public void userSeeOnlySearchedBranch() {
        branchHomePage.searchedBranchDetailsExist();
    }


    @Then("^User see new branch created successfully$")
    public void userSeeNewBranchCreatedSuccessfully() {
        branchHomePage.verifyBranchDetailExist();
    }

    @Then("^User see branch details$")
    public void userSeeBranchDetails() {
        branchHomePage.verifyBranchDetails();
    }

    @Then("^User see updated branch details$")
    public void userSeeUpdatedBranchDetails() {
        branchHomePage.verifyBranchDetailExist();
    }

    @Then("^User can not see that branch in branches$")
    public void userCanNotSeeBranchInBranches() {
        branchHomePage.verifyBranchDetailNotExist();
    }

}
