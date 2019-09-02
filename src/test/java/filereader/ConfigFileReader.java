package filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    //This class provide values from Configuration.properties file to methods using getters
    Properties prop = new Properties();
    FileInputStream fis;
    private String filePath = "src\\test\\resources\\Configuration.properties";

    {
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Configuration.properties not found at " + filePath);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = prop.getProperty("implicitWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getBrowser() {
        String browser = prop.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("browser not specified in the Configuration properties file");
    }

    public String getApplicationUrl() {
        String url = prop.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getUserName() {
        String userName = prop.getProperty("username");
        if (userName != null) return userName;
        else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = prop.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }

    public long getExplicitWait() {
        String explicitWait = prop.getProperty("explicitWait");
        if (explicitWait != null) return Long.parseLong(explicitWait);
        else throw new RuntimeException("explicitWait not specified in the Configuration.properties file.");
    }

}
