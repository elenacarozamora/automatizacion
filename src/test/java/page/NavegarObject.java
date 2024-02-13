package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavegarObject extends BasePageAbstract {
    WebDriver webDriver;
    By li1 = By.xpath("(//ul[@class='products-nav']//li)[1]");
    By li2 = By.xpath("(//ul[@class='products-nav']//li)[2]");
    By li3 = By.xpath("(//ul[@class='products-nav']//li)[3]");
    By li4 = By.xpath("//li[@id='0']");
    By li5 = By.xpath("//li[@id='1']");
    By li6 = By.xpath("(//ul[@class='products-nav']//li)[last()]");
    By help = By.xpath("//a[@name='help-link']");
    By logged = By.xpath("//a[@name='logged-off']");
    By account = By.xpath("//a[@name='cart-link']");
    By pageHome = By.xpath("//a[@name='Oscaro']");

    public NavegarObject(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void navHomeBar() {
        webDriver.findElement(li1).click();
        webDriver.findElement(li2).click();
        webDriver.findElement(li3).click();
        webDriver.findElement(li4).click();
        webDriver.findElement(li5).click();
        webDriver.findElement(li6).click();
        webDriver.findElement(help).click();
        webDriver.findElement(logged).click();
        webDriver.findElement(account).click();
        webDriver.findElement(pageHome).click();
    }
}
