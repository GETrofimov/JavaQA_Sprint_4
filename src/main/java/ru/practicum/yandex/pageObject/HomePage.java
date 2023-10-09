package ru.practicum.yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private By upperOrderButton = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']"); // Кнопка "Заказать"
    private By lowerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By statusButton = By.xpath(".//button[text()='Статус заказа']"); // Кнопка "Статус заказа"
    private By questionList = By.className("accordion");
    private By questionArea;
    private By answerArea;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public By getQuestionList() {
        return questionList;
    }

    public By getQuestionArea(int index) {
        return questionArea = By.id(String.format("accordion__heading-%d", index));
    }

    public By getAnswerArea(int index) {
        return answerArea = By.id(String.format("accordion__panel-%d", index));
    }

    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }
    public By getLowerOrderButton() {
        return lowerOrderButton;
    }
}
