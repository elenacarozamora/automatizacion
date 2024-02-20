package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubCategoria {
    WebDriver webDriver;

    public SubCategoria(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public List<WebElement> getNombresSubcategorias(Integer Num) {
        return webDriver.findElements(By.xpath("(((//ul[@class='list-collapse link-tertiary'])[" + Num + "]/li)/span)"));
    }
}
