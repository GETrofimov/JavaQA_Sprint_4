package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.practicum.yandex.constants.Answers;
import ru.practicum.yandex.constants.GeckoWebDriverPath;
import ru.practicum.yandex.constants.Questions;
import ru.practicum.yandex.constants.URLs;
import ru.practicum.yandex.pageObject.HomePage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQSectionTests {
    private final int order;
    private final String answerText;
    private final String questionText;
    private WebDriver driver;

    public FAQSectionTests(String questionText, String answerText, int order) {
        this.questionText = questionText;
        this.answerText = answerText;
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][] {
                //Не стал выносить номер порядка в константы т.к. итак прозрачная переменная
        {Questions.QUESTION_1, Answers.ANSWER_1, 0},
        {Questions.QUESTION_2, Answers.ANSWER_2, 1},
        {Questions.QUESTION_3, Answers.ANSWER_3, 2},
        {Questions.QUESTION_4, Answers.ANSWER_4, 3},
        {Questions.QUESTION_5, Answers.ANSWER_5, 4},
        {Questions.QUESTION_6, Answers.ANSWER_6, 5},
        {Questions.QUESTION_7, Answers.ANSWER_7, 6},
        {Questions.QUESTION_8, Answers.ANSWER_8, 7}
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
//
//    }

//Настройки для запуска в Chrome
    public void startBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(URLs.MAIN);
    }

    @Test
    public void checkQuestionTextAnswerTextAndSequence() {
        driver.get(URLs.MAIN);
        HomePage faqSection = new HomePage(driver);

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(faqSection.getQuestionList()));

        driver.findElement(faqSection.getQuestionArea(order)).click();
        WebElement question = driver.findElement(faqSection.getQuestionArea(order));
        WebElement answer = driver.findElement(faqSection.getAnswerArea(order));

        assertEquals(questionText, question.getText());
        assertEquals(answerText, answer.getText());
        }

    @After
    public void teardown() {
        driver.quit();
    }
}

