package ru.practicum.yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHeader {
    private WebDriver driver;
    private By orderButton = By.xpath(".//button[text()='Заказать']");
    private By statusButton = By.xpath(".//button[text()='Статус заказа']");

    public HomePageHeader(WebDriver driver) {
        this.driver=driver;
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
