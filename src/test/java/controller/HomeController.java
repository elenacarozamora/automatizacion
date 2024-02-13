package controller;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.*;

import java.io.IOException;

public class HomeController extends BaseControllerAbstract {
    ValidarObject indexPage = new ValidarObject(driver);
    NavegarObject homePage = new NavegarObject(driver);
    CategoriaObject categoriaPage = new CategoriaObject(driver);
    FamiliaObject familiasPage = new FamiliaObject(driver);
    SubCategoriasObject subCategoriasPage = new SubCategoriasObject(driver);
    ProductoObjetct productoObjetct = new ProductoObjetct(driver);


    @When("^Entrar pagina principal$")
    public void entrarPagina() throws IOException {
        setup();
        indexPage.validarHome();
    }

    @Then("^Navegar por los tipos de servicios$")
    public void recambiosCoches() {
        homePage.navHomeBar();
    }

    @When("^(.*) nombres$")
    public void guardarNombre(final String action) throws IOException {
        switch (action) {
            case "Guardar":
                categoriaPage.crearJson(getRuta());
                break;
            case "Subcategoria":
                subCategoriasPage.crearSubcategorJson(getRuta());
                break;
            case "Familia":
                familiasPage.crearFamiliasJson(getRuta());
                break;
            default:
                productoObjetct.crearProductoJson(getRuta());
        }
    }

    @Then("^Eliminar ficheros$")
    public void eliminarFichero() throws IOException {
        categoriaPage.eliminarFichero(getRuta());
    }

    @And("^Cerrar pagina$")
    public void cerrarPagina() {
        tearDown();
    }

}
