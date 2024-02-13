package page;


import Data.Categoria;
import Data.Familia;
import Data.SubCategoria;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.FicheroUtl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamiliaObject extends BasePageAbstract {

    WebDriver webDriver;
    FicheroUtl ficheroUtl;

    public FamiliaObject(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        ficheroUtl = new FicheroUtl();
    }

    public boolean crearFamiliasJson(String ruta) {
        guardarFamilias(ruta, cargarFichero(ruta, ficheroUtl));
        return true;
    }

    public void waitElementFamilia(Integer numCategorias, Integer numSubCategorias) {
        String objClass = "((//ul[@class='list-collapse link-tertiary'])[";
        try {
            waitForElement(webDriver, By.xpath(objClass + numCategorias + "]/li)[" + numSubCategorias + "]/ul/li/a"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarFamilias(String ruta, JsonObject json) {
        Categoria categorias = new Categoria(webDriver);
        List<WebElement> listCat = categorias.getNombresCategorias();
        SubCategoria subCategoria = new SubCategoria(webDriver);
        Familia familia = new Familia(webDriver);
        Map<String, Map> mapCategoriasMap = new HashMap();
        int numCategorias = 1;
        for (WebElement cat : listCat) {
            List<WebElement> listSub = subCategoria.getNombresSubcategorias(numCategorias);
            int numSubCategorias = 1;
            Map<String, List> subCategoriaMap = new HashMap();
            for (WebElement subCat : listSub) {
                List<String> listFamilias = new ArrayList();
                List<WebElement> listadoXpathFamilias = familia.getNombresFamilia(numCategorias, numSubCategorias);
                waitElementFamilia(numCategorias, numSubCategorias);
                for (WebElement familiaObj : listadoXpathFamilias) {
                    listFamilias.add(familiaObj.getText());
                }
                try {
                    subCategoriaMap.put(subCat.getText(), listFamilias);
                } catch (Exception e) {
                    subCategoriaMap.put("No se cargaron familias para esta subcategpria", listFamilias);
                }
                numSubCategorias++;
            }
            mapCategoriasMap.put(cat.getText(), subCategoriaMap);
            numCategorias++;
        }
        writeJsonFile("Array", mapCategoriasMap, ruta, json);
    }
}