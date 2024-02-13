package page;


import Data.Categoria;
import Data.Familia;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoObjetct extends BasePageAbstract {

    WebDriver webDriver;
    FicheroUtl ficheroUtl;

    public ProductoObjetct(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        ficheroUtl = new FicheroUtl();
    }

    public boolean crearProductoJson(String ruta) {
        guardarProducto(ruta, cargarFichero(ruta, ficheroUtl));
        return true;
    }

    public void guardarProducto(String ruta, JsonObject json) {
        Categoria categorias = new Categoria(webDriver);
        SubCategoria subCategoria = new SubCategoria(webDriver);
        Familia familia = new Familia(webDriver);
        List<WebElement> listCat = categorias.getNombresCategorias();
        int numCat = 1;
        for (WebElement cat : listCat) {
            List<WebElement> listSub = subCategoria.getNombresSubcategorias(numCat);
            ArrayList mapSub = new ArrayList();
            int numSubCat = 1;
            Map<String, List> mapFamilia = new HashMap();

            for (WebElement subCat : listSub) {
                List<WebElement> listProducto = familia.getNombresFamilia(numCat, numSubCat);
                ArrayList famil = new ArrayList();
                for (WebElement producto : listProducto) {
                    famil.add(producto.getText());
                }
                mapFamilia.put(subCat.getText(), famil);
                numSubCat++;
            }
            writeJsonFileFamilia(cat.getText(), mapFamilia, ruta, json);
            numCat++;
        }
    }

    public void writeJsonFileFamilia(String cat, Map mapObj, String ruta, JsonObject json) {
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
