package pageobjects;

import filereader.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    ConfigFileReader configFileReader = new ConfigFileReader();

    private String loginPageUrl = "http://127.0.0.1:8080/#/login";

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-primary ng-scope']")
    private WebElement authenticateButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected By getUniqueElement() {
        return (By) authenticateButton;
    }

    public HomePage login() {
        driver.get(loginPageUrl);
        usernameField.sendKeys(configFileReader.getUserName());
        passwordField.sendKeys(configFileReader.getPassword());
        authenticateButton.click();
        return new HomePage(driver);
    }
}
