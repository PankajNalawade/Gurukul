package pageobjects;

import helpers.RandomStringGenerator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSettingsPage extends AbstractPage {
    private String firstName;
    private String lastName;
    private String email;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[@class='btn btn-primary ng-scope']")
    private WebElement saveButton;

    public UserSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected By getUniqueElement() {
        return (By) firstNameField;
    }

    public void updateUserAccountInformation() {
        firstName = RandomStringGenerator.getRandomString(6);
        lastName = RandomStringGenerator.getRandomString(6);
        email = RandomStringGenerator.getRandomString(8) + "@gamil.com";
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        emailField.clear();
        emailField.sendKeys(email);
        saveButton.click();
    }

    public void verifySuccessfulUserInfoUpdate() {
        driver.navigate().refresh();
        Assert.assertEquals(firstName, firstNameField.getAttribute("value"));
        Assert.assertEquals(lastName, lastNameField.getAttribute("value"));
        Assert.assertEquals(email, emailField.getAttribute("value"));
    }
}
