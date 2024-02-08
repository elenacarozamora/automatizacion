package selenium.code.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

    @FindBy(xpath = "(//button[@class='btn-default'])[1]")
    private WebElement btnDefault;


    public void validarHome(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement response = wait.until(ExpectedConditions.visibilityOfElementLocated((By) btnDefault));
        response.click();
    }
}
