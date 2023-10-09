package ru.practicum.yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Для кого самокат
    private By name = By.cssSelector("[placeholder='* Имя']");
    private By lastName = By.cssSelector("[placeholder='* Фамилия']");
    private By address = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    private By metroStation = By.className("select-search");
    private By phoneNumber = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");
    private By metroSelectOptionsList = By.className("select-search__options");

    //getters
    public By getName() {
        return name;
    }

    public By getLastName() {
        return lastName;
    }

    public By getAddress() {
        return address;
    }

    public By getPhoneNumber() {
        return phoneNumber;
    }

    //setters
    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void setLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
    }
    private void selectMetroStationOption(int dataValue) {
        driver.findElement(By.xpath(String.format(".//li[@class='select-search__row' and @data-value='%d']", dataValue))).click();
    }


    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void selectMetroStation(int dataValue) {
        driver.findElement(metroStation).click();
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(metroSelectOptionsList));
        selectMetroStationOption(dataValue);
    }

    //Про аренду
    private By deliveryDate = By.className("Order_MixedDatePicker__3qiay");
    private By rentPeriod = By.className("Dropdown-control");
    private By comment = By.cssSelector("[placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By confirmationModal = By.className("Order_ModalHeader__3FDaJ");
    private By confirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By declineButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Нет']");
    private By datePicker = By.className("react-datepicker-popper");


    public WebElement getConfirmationModal() {
        return driver.findElement(confirmationModal);
    }

    public void selectDay(int day) {
        driver.findElement(deliveryDate).click();
        driver.findElement(By.xpath(String.format(".//div[text()='%d']", day))).click();
    }
    public void selectPeriod(int period) {
        driver.findElement(rentPeriod).click();
        driver.findElement(By.xpath(String.format(".//div[@class='Dropdown-menu']/div[%d]", period))).click();
    }
    public void submit() {
        driver.findElement(confirmButton).click();
    }
    public void decline() {
        driver.findElement(declineButton).click();
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

}