package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Categoria {
    WebDriver webDriver;

    public Categoria(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public List<WebElement> getNombresCategorias() {
        return webDriver.findElements(By.xpath("(//div[@class='category-item-header']//h2/a)"));
    }

}
