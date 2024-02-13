package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    List<WebElement> nombres;
    WebDriver webDriver;
    ArrayList<SubCategoria> subCategorias = new ArrayList<>();

    public Categoria(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public ArrayList<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(ArrayList<SubCategoria> subCategorias) {
        this.subCategorias = subCategorias;
    }

    public List<WebElement> getNombresCategorias() {
        return webDriver.findElements(By.xpath("//div[@class='category-item-header']//h2/a"));
    }

}
