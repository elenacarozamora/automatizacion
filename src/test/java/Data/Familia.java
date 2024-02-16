package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import static java.lang.Thread.sleep;

public class Familia {
    WebDriver webDriver;

    public Familia(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void clickVerMas() {
        List<WebElement> verMas = webDriver.findElements(By.xpath("(//li[@class='bold m-t-100'])"));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        int cont = 1;
        for (WebElement verM : verMas) {
            js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("(//li[@class='bold m-t-100'])[" + cont + "]")));

            webDriver.findElement(By.xpath("(//li[@class='bold m-t-100'])[" + cont + "]")).click();
            cont++;
        }
    }

    public List<WebElement> getNombresFamilia(Integer cat, Integer sub) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li)[" + sub + "]")));

        sleep(3000);
        webDriver.findElement(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li)[" + sub + "]")).click();
        js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li)[" + sub + "]/ul/li/a")));

        sleep(2000);
        List<WebElement> result = webDriver.findElements(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li)[" + sub + "]/ul/li/a"));
        return result;
    }

    public void cerrarSubcategoria(Integer cat) {
        webDriver.findElement(By.xpath("((//ul[@class='list-collapse link-tertiary'])[" + cat + "]/li[@class='open']//span)[1]")).click();
    }
}
