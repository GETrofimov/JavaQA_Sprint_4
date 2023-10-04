package ru.practicum.yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    private By name = By.cssSelector("[placeholder='* Имя']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }
}
