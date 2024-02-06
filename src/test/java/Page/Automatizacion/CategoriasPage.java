package Page.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class CategoriasPage {

    //final variables
    public static final String PAGE_TITLE = "Todos los recambios de coche";
    public static final String PAGE_URL = "https://www.oscaro.es/";

    //local webdriver variable
    WebDriver driver;

    @FindBy(xpath="//div[@id='categoriesTree']")
    WebElement treeCategorias;

    //Page Class Constructor
    public CategoriasPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
}
