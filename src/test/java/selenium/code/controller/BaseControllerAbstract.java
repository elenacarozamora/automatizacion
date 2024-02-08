package selenium.code.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.code.utilities.PropertiesUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseControllerAbstract {

    public WebDriver driver = new ChromeDriver();

    public static Properties getProperties() throws IOException {
        PropertiesUrl protUrl = new PropertiesUrl();
        String propt = protUrl.getRutaProperties();
        File file = new File(propt);
        FileInputStream configFileReader = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(configFileReader);
        return prop;
    }

    public static String getRuta() throws IOException {
        return getProperties().getProperty("env.ruta");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setup() throws IOException {
        driver.get(getUrl());
    }

    public void setUp(String url) {
        driver = new ChromeDriver();
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
