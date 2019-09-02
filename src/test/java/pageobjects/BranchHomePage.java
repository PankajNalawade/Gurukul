package pageobjects;

import helpers.ClickElement;
import helpers.RandomStringGenerator;
import helpers.Waiter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BranchHomePage extends AbstractPage {

    public String createdBranchName;
    private String createdBranchCode;
    private WebElement element;

    @FindBy(xpath = "//div[@class='col-md-4']//button")
    private WebElement createNewBranchButton;

    @FindBy(name = "name")
    private WebElement branchName;

    @FindBy(name = "code")
    private WebElement branchCode;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement deleteButton;

    @FindBy(id = "searchQuery")
    private WebElement searchQueryField;

    @FindBy(xpath = "//button[@class='btn btn-info']")
    private WebElement searchBranchButton;

    @FindBy(xpath = "//table[@class='table table-striped']")
    private WebElement branchesTable;

    @FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]//input")
    private WebElement branchNameField;

    By tableBranchName = By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]");

    public BranchHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected By getUniqueElement() {
        return (By) createNewBranchButton;
    }

    public void createNewbranch() {
        createNewBranchButton.click();
        createdBranchName = RandomStringGenerator.getRandomString(8);
        branchName.sendKeys(createdBranchName);
        createdBranchCode = RandomStringGenerator.getRandomString(3).toUpperCase();
        branchCode.sendKeys(createdBranchCode);
        saveButton.click();
    }

    public void verifyBranchDetailExist() {
        driver.navigate().refresh();
        boolean isFound = false;
        List<WebElement> branchNames = branchesTable.findElements(tableBranchName);
        for (int i = 0; i < branchNames.size(); i++) {
            if (branchNames.get(i).getText().equals(createdBranchName)) {
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound);
    }

    public void verifyBranchDetailNotExist() {
        driver.navigate().refresh();
        boolean isFound = true;
        List<WebElement> branchNames = branchesTable.findElements(tableBranchName);
        for (int i = 0; i < branchNames.size(); i++) {
            if (branchNames.get(i).getText().equals(createdBranchName)) {
                isFound = false;
                break;
            }
        }
        Assert.assertTrue(isFound);
    }

    public void OpenExistingBranch() {
        createNewbranch();
        element = driver.findElement(By.xpath("//td[contains(text()," + "'" + createdBranchName + "'" + ")]/following-sibling::td[2]/button[@class='btn btn-info btn-sm']"));
        ClickElement.clickOnWebElement(driver, element);
    }

    public void verifyBranchDetails() {
        Waiter.waitForElementExist(driver, branchNameField);
        Assert.assertEquals(branchNameField.getAttribute("value"), createdBranchName);
    }

    public void updateExistingBranch() {
        createNewbranch();
        element = driver.findElement(By.xpath("//td[contains(text()," + "'" + createdBranchName + "'" + ")]/following-sibling::td[2]/button[@class='btn btn-primary btn-sm']"));
        element.click();
        createdBranchName = RandomStringGenerator.getRandomString(8);
        branchName.clear();
        branchName.sendKeys(createdBranchName);
        saveButton.click();
    }

    public void deleteExistingBranch() {
        createNewbranch();
        element = driver.findElement(By.xpath("//td[contains(text()," + "'" + createdBranchName + "'" + ")]/following-sibling::td[2]/button[@class='btn btn-danger btn-sm']"));
        ClickElement.clickOnWebElement(driver, element);
        deleteButton.click();
    }

    public void searchedExistingBranch() {
        createNewbranch();
        element = driver.findElement(By.xpath("//td[contains(text()," + "'" + createdBranchName + "'" + ")]"));
        Waiter.waitForElementExist(driver, searchQueryField);
        searchQueryField.clear();
        searchQueryField.sendKeys(createdBranchName);
        ClickElement.clickOnWebElement(driver, searchBranchButton);
    }

    public void searchedBranchDetailsExist() {
        Waiter.waitForElementExist(driver, branchesTable.findElement(tableBranchName));
        Assert.assertEquals(createdBranchName, branchesTable.findElement(tableBranchName).getText());
        Assert.assertTrue(branchesTable.findElements(tableBranchName).size() == 1);
    }
}
