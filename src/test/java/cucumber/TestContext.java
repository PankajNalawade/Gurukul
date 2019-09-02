package cucumber;

import filereader.ConfigFileReader;
import managers.DriverManager;
import managers.PageObjectManager;

import java.io.IOException;

public class TestContext {
    private DriverManager driverManager;
    private ConfigFileReader configFileReader;
    private PageObjectManager pageObjectManager;

    public TestContext() throws IOException {
        driverManager = new DriverManager();
        configFileReader = new ConfigFileReader();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return configFileReader;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
