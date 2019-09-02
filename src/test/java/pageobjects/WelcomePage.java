package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends AbstractPage {

    @FindBy(linkText = "login")
    private WebElement loginLink;

    @FindBy(linkText = "Register a new account")
    private WebElement registerNewAccountLink;

    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected By getUniqueElement() {
        return (By) loginLink;
    }

    public void verifyUserOnWelcomePage() {
        Assert.assertTrue(loginLink.isDisplayed());
        Assert.assertTrue(registerNewAccountLink.isDisplayed());
    }
}
