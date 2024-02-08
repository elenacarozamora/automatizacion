package selenium.code.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.code.utilities.FicheroUtl;

import java.io.IOException;
import java.util.List;

public class CategoriaPage {

    @FindBy(xpath = "(//h2/a)[1]")
    private WebElement piezasMotor;

    @FindBy(xpath = "(//h2/a)[2]")
    private WebElement filtroAceite;

    @FindBy(xpath = "(//h2/a)[3]")
    private WebElement opticas;

    public void crearJson(WebDriver driver) throws IOException {
        FicheroUtl.crearJsonFile();
        guardarOpticas(driver);
        guardarFiltroAceite(driver);
        guardarPiezas(driver);
    }

    public void guardarOpticas(WebDriver driver) {
        List<WebElement> opticasListado = driver.findElements(By.xpath("(//h2/a)[3]/../../..//li/span"));
        int contOpt = 0;
        for (WebElement optica : opticasListado) {
            System.out.println("Paragraph text:" + optica.getText());
            FicheroUtl.writeJsonFile("opticas" + contOpt + ":", optica.getText());
            contOpt++;
        }
    }

    public void guardarFiltroAceite(WebDriver driver) {
        List<WebElement> filtroListado = driver.findElements(By.xpath("(//h2/a)[2]/../../..//li/span"));
        int contFil = 0;
        for (WebElement filtro : filtroListado) {
            System.out.println("Paragraph text:" + filtro.getText());
            FicheroUtl.writeJsonFile("filtro" + contFil + ":", filtro.getText());
            contFil++;
        }
    }

    public void guardarPiezas(WebDriver driver) {
        List<WebElement> piezasListado = driver.findElements(By.xpath("(//h2/a)[1]/../../..//li/span"));
        int cont = 0;
        for (WebElement element : piezasListado) {
            System.out.println("Paragraph text:" + element.getText());
            FicheroUtl.writeJsonFile("categoria" + cont + ":", element.getText());
            cont++;
        }
    }

    public void eliminarJson() throws IOException {
        FicheroUtl.eliminarJsonFile();
    }
}
