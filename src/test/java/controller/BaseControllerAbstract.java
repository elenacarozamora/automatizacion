package controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.PropertiesUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseControllerAbstract {
    WebDriver driver = new ChromeDriver();

    public static Properties getProperties() throws IOException {
        PropertiesUrl protUrl = new PropertiesUrl();
        String propt = protUrl.getRutaProperties();
        File file = new File(propt);
        FileInputStream configFileReader = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(configFileReader);
        return prop;
    }

    public String getRuta() throws IOException {
        return getProperties().getProperty("env.ruta");
    }

    public void setup() throws IOException {
        driver.manage().window().maximize();
        driver.get(getProperties().getProperty("env.url"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setUp(String url) {
        driver.get(url);
    }

    public String getUrl() throws IOException {
        return getProperties().getProperty("env.url");
    }

    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
