package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.practicum.yandex.constants.URLs;
import ru.practicum.yandex.pageObject.HomePage;
import ru.practicum.yandex.pageObject.OrderPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScooterOrder {
    private WebDriver driver;

    @Before
//Настройки для запуска в Firefox
//    public void startBrowser() {
//        System.setProperty("webdriver.gecko.driver", GeckoWebDriverPath.PATH);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        driver = new FirefoxDriver(capabilities);
//        driver.get(URLs.MAIN);
//
//    }

//Настройки для запуска в Chrome
    public void startBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        driver.get(URLs.MAIN);
    }


    @Test
    public void CheckName() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setName("Григорий");
        objOrderPage.setLastName("Трофимов");
        objOrderPage.setAddress("Москва");
        objOrderPage.setPhoneNumber("8-800-555-35-35");
        objOrderPage.selectMetroStation(12);

        objOrderPage.clickNextButton();

        objOrderPage.selectDay(28);
        objOrderPage.selectPeriod(2);

        objOrderPage.clickOrderButton();

        assertEquals(true, objOrderPage.getConfirmationModal().isDisplayed());

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
