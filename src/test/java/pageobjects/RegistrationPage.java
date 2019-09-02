package pageobjects;

import helpers.RandomNumberGenerator;
import helpers.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends AbstractPage {

    private String loginPageUrl = "http://127.0.0.1:8080/#/register";

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@class='btn btn-primary ng-scope']")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected By getUniqueElement() {
        return null;
    }

    public HomePage performRegistration() {
        loginField.sendKeys(RandomStringGenerator.getRandomString(7));
        emailField.sendKeys(RandomStringGenerator.getRandomString(7) + "@hotmail.com");
        String password = RandomStringGenerator.getRandomString(8) + RandomNumberGenerator.getrandomNumber();
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        registerButton.click();
        return new HomePage(driver);
    }

    public void navigateToRegistrationPage() {
        driver.get(loginPageUrl);
    }
}
