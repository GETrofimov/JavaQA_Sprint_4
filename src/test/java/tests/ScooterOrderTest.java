package tests;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.practicum.yandex.constants.*;
import ru.practicum.yandex.pageObject.HomePage;
import ru.practicum.yandex.pageObject.OrderPage;
import ru.practicum.yandex.pageObject.SharedElements;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    private WebDriver driver;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String address;
    private int metroStation;
    private int day;
    private int period;

    public ScooterOrderTest(String name, String lastName, String address, String phoneNumber, int metroStation, int day, int period) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStation = metroStation;
        this.day = day;
        this.period = period;

    }

    @Parameterized.Parameters
    public static Object[][] getFillData() {
        return new Object[][] {
                {OrderData.NAME, OrderData.LAST_NAME, OrderData.ADDRESS, OrderData.PHONE_NUMBER, MetroStations.CHERKIZOVSKAYA, CalendarDays.DAY_28, RentPeriods.TWO_DAYS},
                {OrderData.NAME, OrderData.LAST_NAME, OrderData.ADDRESS, OrderData.PHONE_NUMBER, MetroStations.OKHOTNY_RYAD, CalendarDays.DAY_03, RentPeriods.FIVE_DAYS},
        };
    }

    @Before
//Настройки для запуска в Firefox
//    public void startBrowser() {
//        System.setProperty("webdriver.gecko.driver", GeckoWebDriverPath.PATH);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        driver = new FirefoxDriver(capabilities);
//        driver.get(URLs.MAIN);
//        SharedElements cookieBlock = new SharedElements(driver);
//        cookieBlock.clickCloseCookieButton();
//
//    }

//Настройки для запуска в Chrome
    public void startBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        driver.get(URLs.MAIN);
        SharedElements cookieBlock = new SharedElements(driver);
        cookieBlock.clickCloseCookieButton();
    }


    @Test
    public void CheckName() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setName(name);
        objOrderPage.setLastName(lastName);
        objOrderPage.setAddress(address);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.selectMetroStation(metroStation);
        objOrderPage.clickNextButton();

        objOrderPage.selectDay(day);
        objOrderPage.selectPeriod(period);

        objOrderPage.clickOrderButton();
        objOrderPage.submit();

        MatcherAssert.assertThat("Confirmation process was not finished", objOrderPage.getConfirmationModal().getText(), containsString("Заказ оформлен"));

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
