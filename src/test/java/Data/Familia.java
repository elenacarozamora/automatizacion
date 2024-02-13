package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Familia {
    WebDriver webDriver;
    String nombre;
    ArrayList<Producto> productos;

    public Familia(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public List<WebElement> getNombresFamilia(Integer cat, Integer sub) {
        webDriver.findElement(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li)[" + sub + "]")).click();
        return webDriver.findElements(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li)[" + sub + "]/ul/li/a"));
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
