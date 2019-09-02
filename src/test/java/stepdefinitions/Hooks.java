package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {
    TestContext testcontext;

    public Hooks(TestContext context) {
        testcontext = context;
    }

    //If any scenario fails then below code in tear down take a screenshot and attached to the report present under target/cucumber-html-report/index.html file
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot;
            try {
                screenshot = ((TakesScreenshot) testcontext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        testcontext.getDriverManager().tearDown();
    }

}
