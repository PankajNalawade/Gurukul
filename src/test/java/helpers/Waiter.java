package helpers;

import filereader.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Waiter {
    ConfigFileReader configFileReader = new ConfigFileReader();

    //Method wait till element exist for max of 30 seconds with the retry period of 1 second
    public static void waitForElementExist(WebDriver driver, WebElement element) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
    }

    //Method wait till element clickable for max of seconds provided in Configuration.properties file
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getExplicitWait());
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
