package page;


import Data.Categoria;
import Data.SubCategoria;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.FicheroUtl;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SubCategoriasObject extends BasePageAbstract {

    WebDriver webDriver;
    FicheroUtl ficheroUtl;

    public SubCategoriasObject(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        ficheroUtl = new FicheroUtl();
    }

    public boolean crearSubcategorJson(String ruta) {
        guardarSubCategorias(ruta, cargarFichero(ruta, ficheroUtl));
        return true;
    }

    public void guardarSubCategorias(String ruta, JsonObject json) {
        Categoria categorias = new Categoria(webDriver);
        SubCategoria subCategoria = new SubCategoria(webDriver);
        List<WebElement> listCat = categorias.getNombresCategorias();
        int numCat = 1;
        for (WebElement cat : listCat) {
            List<WebElement> listSub = subCategoria.getNombresSubcategorias(numCat);
            List<String> map = new ArrayList();
            for (WebElement subCat : listSub) {
                map.add(subCat.getText());
            }
            writeJsonFileSub(cat.getText(), map, ruta, json);
            numCat++;
        }
    }

    public void writeJsonFileSub(String cat, List mapObj, String ruta, JsonObject json) {
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
