package ru.practicum.yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharedElements {
    private WebDriver driver;

    private By closeCookieButton = By.id("rcc-confirm-button");

    public SharedElements(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCloseCookieButton() {
        driver.findElement(closeCookieButton).click();
    }
}
