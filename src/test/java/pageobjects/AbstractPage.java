package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {
    protected WebDriver driver = null;
    protected WebDriverWait wait = null;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        isLoaded();
    }

    protected abstract By getUniqueElement();

    public void isLoaded() throws Error {
        if (getUniqueElement() != null) {
            List<WebElement> elements = driver.findElements(getUniqueElement());
            Assert.assertTrue("wait for element to be loaded", elements.size() > 0);
            wait.until(ExpectedConditions.visibilityOfElementLocated(getUniqueElement()));
        }
    }
}
