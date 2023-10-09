package tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.practicum.yandex.pageObject.HomePage;
import ru.practicum.yandex.pageObject.OrderPage;

public class OrderPageFill {
    private WebDriver driver;

    @Test
    public void CheckName() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillName("Григорий");

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
