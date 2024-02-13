package page;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FicheroUtl;

import java.nio.file.Paths;
import java.util.Map;

public abstract class BasePageAbstract {

    public WebElement waitForElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public JsonObject cargarFichero(String ruta, FicheroUtl ficheroUtl) {
        eliminarJsonFile(ruta, ficheroUtl);
        return ficheroUtl.crearJsonFile();
    }


    public boolean eliminarJsonFile(String ruta, FicheroUtl ficheroUtl) {
        try {
            return ficheroUtl.eliminarJsonFile(ruta);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
