package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidarObject extends BasePageAbstract {
    WebDriver webDriver;

    public ValidarObject(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void validarHome() throws InterruptedException {
        By btnDelt = By.xpath("(//button[@class='btn-default'])[1]");
        waitForElement(webDriver, btnDelt);
        webDriver.findElement(btnDelt).click();
    }
}

