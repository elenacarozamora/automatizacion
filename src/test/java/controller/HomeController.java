package controller;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import page.*;

import java.io.IOException;

public class HomeController extends BaseControllerAbstract {

    @Steps
    ValidarObject indexPage = new ValidarObject(driver);

    @Steps
    NavegarObject homePage = new NavegarObject(driver);

    @Steps
    CategoriaObject categoriaPage = new CategoriaObject(driver);

    @Steps
    FamiliaObject familiasPage = new FamiliaObject(driver);

    @Steps
    SubCategoriasObject subCategoriasPage = new SubCategoriasObject(driver);

    @Steps
    ProductoObjetct productoObjetct = new ProductoObjetct(driver);


    @When("^Entrar pagina principal$")
    public void entrarPagina() throws IOException, InterruptedException {
        setup();
        indexPage.validarHome();
    }

    @Then("^Navegar por los tipos de servicios$")
    public void recambiosCoches() {
        homePage.navHomeBar();
    }

    @When("^(.*) nombres$")
    public void guardarNombre(final String action) throws IOException, InterruptedException {
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
