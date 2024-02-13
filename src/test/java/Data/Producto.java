package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Producto {
    String descripcion;
    String nombre;
    String precio;
    WebDriver webDriver;

    public Producto(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public List<WebElement> getNombresProductos(Integer cat, Integer sub, Integer familia) {
        return webDriver.findElements(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li)[" + sub + "]/ul/li"));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
