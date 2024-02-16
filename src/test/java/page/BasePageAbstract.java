package page;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FicheroUtl;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

import static java.lang.Thread.sleep;

public abstract class BasePageAbstract {

    public void waitForElement(WebDriver driver, By locator) throws InterruptedException {
        //new WebDriverWait(driver, 6).until(ExpectedConditions.elementToBeClickable(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));

    }

    public JsonObject cargarFichero(String ruta, FicheroUtl ficheroUtl) {
        eliminarJsonFile(ruta, ficheroUtl);
        return ficheroUtl.crearJsonFile();
    }


    public void eliminarJsonFile(String ruta, FicheroUtl ficheroUtl) {
        try {
            ficheroUtl.eliminarJsonFile(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeJsonFile(String cat, Map mapObj, String ruta, JsonObject json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            json.put(cat, mapObj);
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get(ruta).toFile(), json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
