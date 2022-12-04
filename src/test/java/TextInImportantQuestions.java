import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TextInImportantQuestions {

    private WebDriver driver;

    @Test
    public void checkTextFirefox() {
        driver = Drivers.getFirefoxDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitForImportantQuestionsIsRendered();
        homePageScooter.clickToCook();
        homePageScooter.checkImportantQuestions();
    }

    @Test
    public void checkTextChrome() {
        driver = Drivers.getChromeDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitForImportantQuestionsIsRendered();
        homePageScooter.clickToCook();
        homePageScooter.checkImportantQuestions();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}