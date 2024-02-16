package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Producto {
    WebDriver webDriver;

    public Producto(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    Logger logger = Logger.getLogger(Producto.class.getName());

    public void getNombresProductos(Integer cat, Integer sub, Integer familia) {
        webDriver.findElement(By.xpath("(((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li))[" + sub + "]")).click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        try {
            js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("(((//div[@class='category-item-header']/..)[" + cat + "]//..//li[@class='open'])[[" + sub + "]]//ul/li)[" + familia + "]")));
            sleep(2000);
            webDriver.findElement(By.xpath("(((//div[@class='category-item-header']/..)[" + cat + "]//..//li[@class='open'])[[" + sub + "]]//ul/li)[" + familia + "]")).click();

        } catch (Exception e) {

        }
        webDriver.findElement(By.xpath("//button[@class='popin-close ico-cross']")).click();
    }

    public List<WebElement> getListadoProductos() {
        return webDriver.findElements(By.xpath("(//article[@class='product-card'])"));
    }

    public void volverHome() {
        try {
            webDriver.findElement(By.xpath("(//span[@itemprop='name'])[1]")).click();
        } catch (Exception e) {
            logger.warning("No se muestra el vlver a la página Principal.");
        }
    }

    public void clickPage() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("//li[@class='next']/a")));
        webDriver.findElement(By.xpath("//li[@class='next']/a")).click();

    }
}
