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

    public CategoriaObject(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        ficheroUtl = new FicheroUtl();
    }

    public void crearJson(String ruta) {
        try {
            eliminarFichero(ruta);
            JsonObject json = ficheroUtl.crearJsonFile();
            guardarCategorias(ruta, json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void guardarCategorias(String ruta, JsonObject json) throws InterruptedException {
        Categoria categorias = new Categoria(webDriver);
        By element = By.xpath("//div[@class='category-item-header']//h2/a");
        waitForElement(webDriver, element);
        List<WebElement> list = categorias.getNombresCategorias();
        for (WebElement cat : list) {
            writeJsonFile(cat.getText(), ruta, json);
        }
    }

    public void writeJsonFile(String cat, String ruta, JsonObject json) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            json.put(cat, map);
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get(ruta).toFile(), json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarFichero(String ruta) {
        eliminarJsonFile(ruta, ficheroUtl);
    }

}
