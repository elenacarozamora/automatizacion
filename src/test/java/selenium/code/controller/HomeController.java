package selenium.code.controller;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.code.page.CategoriaPage;
import selenium.code.page.HomePage;
import selenium.code.page.IndexPage;

import java.io.IOException;

public final class HomeController extends BaseControllerAbstract {

    private IndexPage indexPage;
    private HomePage homePage;
    private CategoriaPage categoria;


    @When("^Entrar pagina principal$")
    public void entrarPagina() throws IOException {
        setup();
        indexPage.validarHome(getDriver());
    }

    @Then("^Navegar por los tipos de servicios$")
    public void recambiosCoches() {
        homePage.navHomeBar(getDriver());
    }

    @When("^(.*) nombres$")
    public void guardarNombre(final String action) throws IOException {
        categoria.crearJson(getDriver());
        categoria.guardarOpticas(getDriver());
        categoria.guardarFiltroAceite(getDriver());
        categoria.guardarPiezas(getDriver());
    }

    @Given("^Eliminar ficheros$")
    public void eliminarFichero() throws IOException {
        categoria.eliminarJson();
    }

}
