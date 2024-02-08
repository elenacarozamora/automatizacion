package selenium.code.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    @FindBy(xpath = "(//ul[@class='products-nav']//li)[1]")
    private WebElement li1;

    @FindBy(xpath = "(//ul[@class='products-nav']//li)[2]")
    private WebElement li2;

    @FindBy(xpath = "(//ul[@class='products-nav']//li)[3]")
    private WebElement li3;

    @FindBy(xpath = "//li[@id='0']")
    private WebElement li4;

    @FindBy(xpath = "//li[@id='1']")
    private WebElement li5;

    @FindBy(xpath = "(//ul[@class='products-nav']//li)[last()]")
    private WebElement li6;

    @FindBy(xpath = "//a[@name='help-link']")
    private WebElement help;

    @FindBy(xpath = "//a[@name='logged-off']")
    private WebElement logged;

    @FindBy(xpath = "//a[@name='cart-link']")
    private WebElement account;

    @FindBy(xpath = "//a[@name='Oscaro']")
    private WebElement pageHome;

    public void navHomeBar(WebDriver webDriver) {
        webDriver.findElement((By) li1).click();
        webDriver.findElement((By) li2).click();
        webDriver.findElement((By) li3).click();
        webDriver.findElement((By) li4).click();
        webDriver.findElement((By) li5).click();
        webDriver.findElement((By) li6).click();
        webDriver.findElement((By) help).click();
        webDriver.findElement((By) logged).click();
        webDriver.findElement((By) account).click();
        webDriver.findElement((By) pageHome).click();
    }

    // method for entering input
    public void enterInputWord(String input, By ident, WebDriver webDriver) {
        webDriver.findElement(ident).clear();
        webDriver.findElement(ident).sendKeys(input);
    }

    // method for clicking on button
    public void clickOnBtn(By login, WebDriver webDriver) {
        webDriver.findElement(login).click();
    }
}
