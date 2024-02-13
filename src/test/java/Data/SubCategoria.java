package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SubCategoria {
    WebDriver webDriver;
    String nombre;
    ArrayList<Familia> familias;

    public SubCategoria(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public List<WebElement> getNombresSubcategorias(Integer Num) {
        return webDriver.findElements(By.xpath("(//ul[@class='list-collapse link-tertiary'])[" + Num + "]/li/span"));
    }

    public ArrayList<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(ArrayList<Familia> familias) {
        this.familias = familias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
