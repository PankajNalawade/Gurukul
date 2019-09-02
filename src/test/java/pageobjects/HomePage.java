package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@ui-sref='home']")
    private WebElement homeLink;

    @FindBy(xpath = "//li[@class='dropdown pointer ng-scope']//a[@class='dropdown-toggle']")
    private WebElement entitiesOption;

    @FindBy(xpath = "//li[@class='dropdown pointer ng-scope open']//li[1]")
    private WebElement branchLink;

    @FindBy(xpath = "//li[@class='dropdown pointer ng-scope open']//li[2]")
    private WebElement staffLink;

    @FindBy(xpath = "//li[@class='dropdown pointer']//a[@class='dropdown-toggle']")
    private WebElement accountOption;

    @FindBy(xpath = "//li[@class='dropdown pointer open']//li[4]")
    private WebElement logoutLink;

    @FindBy(xpath = "//li[@class='dropdown pointer open']//li[1]")
    private WebElement settingsLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected By getUniqueElement() {
        return (By) accountOption;
    }

    public void userIsOnHomePage() {
        Assert.assertTrue(homeLink.isDisplayed());
        Assert.assertTrue(entitiesOption.isDisplayed());
        Assert.assertTrue(accountOption.isDisplayed());
    }

    public WelcomePage logoff() {
        accountOption.click();
        logoutLink.click();
        return new WelcomePage(driver);
    }

    public UserSettingsPage goToUserSettingPage() {
        accountOption.click();
        settingsLink.click();
        return new UserSettingsPage(driver);
    }

    public BranchHomePage goToBranchPage() {
        entitiesOption.click();
        branchLink.click();
        return new BranchHomePage(driver);
    }

    public void goToStaffPage() {
        entitiesOption.click();
        staffLink.click();
    }
}
