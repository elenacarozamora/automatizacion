package page;

import Data.Categoria;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.FicheroUtl;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;


public class CategoriaObject extends BasePageAbstract {

    WebDriver webDriver;
    FicheroUtl ficheroUtl;
    By element = By.xpath("//div[@class='category-item-header']//h2/a");

    public CategoriaObject(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        ficheroUtl = new FicheroUtl();
    }

    public boolean crearJson(String ruta) {
        try {
            eliminarFichero(ruta);
            JsonObject json = ficheroUtl.crearJsonFile();
            guardarCategorias(ruta, json);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void guardarCategorias(String ruta, JsonObject json) {
        Categoria categorias = new Categoria(webDriver);
        waitForElement(webDriver, element);
        List<WebElement> list = categorias.getNombresCategorias();
        for (WebElement cat : list) {
            writeJsonFile(cat.getText(), ruta, json);
        }
    }

    public void writeJsonFile(String cat, String ruta, JsonObject json) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap();
        try {
            json.put(cat, map);
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get(ruta).toFile(), json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean eliminarFichero(String ruta) {
        return eliminarJsonFile(ruta, ficheroUtl);
    }

}