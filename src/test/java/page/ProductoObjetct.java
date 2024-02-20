package page;

import Data.Categoria;
import Data.Familia;
import Data.Producto;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.FicheroUtl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static controller.BaseControllerAbstract.getProperties;
import static java.lang.Thread.sleep;

public class ProductoObjetct extends BasePageAbstract {

    Logger logger = Logger.getLogger(ProductoObjetct.class.getName());

    WebDriver webDriver;
    FicheroUtl ficheroUtl;

    public ProductoObjetct(WebDriver remoteDriver) {
        webDriver = remoteDriver;
        ficheroUtl = new FicheroUtl();
    }

    public void crearProductoJson(String ruta) {
        try {
            Integer categoria = (Integer.valueOf(System.getProperty("param.categoria")) != null) ? Integer.valueOf(System.getProperty("param.categoria")) : Integer.valueOf(getProperties().getProperty("param.categoria"));

            Integer subcategoria = (Integer.valueOf(System.getProperty("param.subcategoria")) != null) ? Integer.valueOf(System.getProperty("param.subcategoria")) : Integer.valueOf(getProperties().getProperty("param.subcategoria"));

            Integer familia = (Integer.valueOf(System.getProperty("param.familia")) != null) ? Integer.valueOf(System.getProperty("param.familia")) : Integer.valueOf(getProperties().getProperty("param.familia"));

            Integer hastaPagina = (Integer.valueOf(System.getProperty("param.hastaPagina")) != null) ? Integer.valueOf(System.getProperty("param.hastaPagina")) : Integer.valueOf(getProperties().getProperty("param.hastaPagina"));
            guardarProducto(ruta, cargarFichero(ruta, ficheroUtl), categoria, subcategoria, familia, hastaPagina);
        } catch (Exception e) {
            logger.warning("Los parámetros de filtro no se coresponden con los datos listados.");
        }
    }

    public void guardarProducto(String ruta, JsonObject json, Integer numCategorias, Integer numSubcategoria, Integer numFamilia, Integer page) throws InterruptedException {
        Categoria categorias = new Categoria(webDriver);
        Familia familia = new Familia(webDriver);
        Producto producto = new Producto(webDriver);
        List<WebElement> listCat = categorias.getNombresCategorias();

        Map<String, Map> mapCategoriasMap = new HashMap<String, Map>();
        Map<String, Map> listFamilias = new HashMap<String, Map>();
        Map<String, Map> subCategoriaMap = new HashMap<String, Map>();
        Map<String, List> listProductos = new HashMap<String, List>();

        List<WebElement> listadoXpathFamilias = familia.getNombresFamilia(numCategorias, numSubcategoria);
        WebElement textCategoria = webDriver.findElement(By.xpath("(((//ul[@class='list-collapse link-tertiary'])[" + numCategorias + "]/li)/span)[" + numSubcategoria + "]"));

        String Fam = listadoXpathFamilias.get(numFamilia - 1).getText();
        String Sub = textCategoria.getText();
        String Cat = listCat.get(numCategorias - 1).getText();
        producto.getNombresProductos(numCategorias, numSubcategoria, numFamilia);
        List<WebElement> listadoXpathProducto = new ArrayList<WebElement>();
        int currentPage = 1;
        while (page >= currentPage) {
            listadoXpathProducto = producto.getListadoProductos();
            int cntProdt = 1;
            List<String> pageProdt = new ArrayList<>();
            String pageNum = "Página " + currentPage + " : ";
            while (cntProdt < listadoXpathProducto.size()) {
                String productoObjt;
                String precio;
                String fabricante;
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                sleep(2000);
                js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("(//article[@class='product-card'])[" + cntProdt + "]")));
                productoObjt = "Descripción: " + webDriver.findElement(By.xpath("(//article[@class='product-card'])[" + cntProdt + "]//h3/span")).getText();
                fabricante = "Fabricante: " + webDriver.findElement(By.xpath("(//article[@class='product-card'])[" + cntProdt + "]//h3/span[@class='product-name']")).getText();

                precio = " Precio: " + webDriver.findElement(By.xpath("(//article[@class='product-card'])[" + cntProdt + "]//p/span")).getText();
                String marca = webDriver.findElement(By.xpath("(//article[@class='product-card'])[" + cntProdt + "]//h3/span/span")).getText();

                pageProdt.add(productoObjt + precio + " Código: " + marca);
                cntProdt++;
            }
            listProductos.put(pageNum, pageProdt);
            currentPage++;
            producto.clickPage();
        }
        listFamilias.put(Fam, listProductos);
        subCategoriaMap.put(Sub, listFamilias);

        mapCategoriasMap.put(Cat, subCategoriaMap);
        writeJsonFile("src/main/Data", mapCategoriasMap, ruta, json);
    }


}
