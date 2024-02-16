package controller;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.*;

import java.io.IOException;

public class HomeController extends BaseControllerAbstract {
    private WebDriver driver ;
    private Scenario scenario;

    public HomeController(WebDriver remoteDriver, Scenario scenario) {
        super();
        driver = remoteDriver;
        this.scenario = scenario;
    }

    @When("^Entrar pagina principal$")
    public void entrarPagina() throws IOException, InterruptedException {
        setup();
        ValidarObject indexPage = new ValidarObject(driver);
        indexPage.validarHome();
    }

    @Then("^Navegar por los tipos de servicios$")
    public void recambiosCoches() {
        NavegarObject homePage = new NavegarObject(driver);
        homePage.navHomeBar();
    }

    @When("^(.*) nombres$")
    public void guardarNombre(final String action) throws IOException, InterruptedException {
        CategoriaObject categoriaPage = new CategoriaObject(driver);
        FamiliaObject familiasPage = new FamiliaObject(driver);
        SubCategoriasObject subCategoriasPage = new SubCategoriasObject(driver);
        ProductoObjetct productoObjetct = new ProductoObjetct(driver);
        switch (action) {
            case "Guardar" -> categoriaPage.crearJson(getRuta());
            case "Subcategoria" -> subCategoriasPage.crearSubcategorJson(getRuta());
            case "Familia" -> familiasPage.crearFamiliasJson(getRuta());
            default -> productoObjetct.crearProductoJsonCom(getRuta());
        }
    }

    @Then("^Eliminar ficheros$")
    public void eliminarFichero() throws IOException {
        CategoriaObject categoriaPage = new CategoriaObject(driver);
        categoriaPage.eliminarFichero(getRuta());
    }

    @And("^Cerrar pagina$")
    public void cerrarPagina() {
        tearDown();
    }

}
