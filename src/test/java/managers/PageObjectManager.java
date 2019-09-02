package managers;

import org.openqa.selenium.WebDriver;
import pageobjects.*;

public class PageObjectManager {

    //This class provide page object if it null otherwise it will return the same object which was initialise before

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private WelcomePage welcomePage;
    private RegistrationPage registrationPage;
    private UserSettingsPage userSettingPage;
    private BranchHomePage branchHomePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public WelcomePage getWelcomePage() {
        return (welcomePage == null) ? welcomePage = new WelcomePage(driver) : welcomePage;
    }

    public RegistrationPage getRegistrationPage() {
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }

    public UserSettingsPage getUserSettingsPage() {
        return (userSettingPage == null) ? userSettingPage = new UserSettingsPage(driver) : userSettingPage;
    }

    public BranchHomePage getBranchHomePage() {
        return (branchHomePage == null) ? branchHomePage = new BranchHomePage(driver) : branchHomePage;
    }
}
