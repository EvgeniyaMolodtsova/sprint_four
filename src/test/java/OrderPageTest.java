import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class OrderPageTest {

    private WebDriver driver;

    @Test
    public void testOrderPageFirefox() {
        driver = Drivers.getFirefoxDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitForHeaderButtonIsClickable();
        homePageScooter.clickToOrderHeaderButton();
        orderPageScooter.waitForOrderForm();
        orderPageScooter.clickToCook();
        orderPageScooter.fillOrderForm("Дмитрий", "Иванов", "Приморская 8", "Трубная", "89998887766");
        orderPageScooter.fillRentForm("04.12.2022", "сутки");
    }

    @Test
    public void testOrderPageMiddleButtonFirefox() {
        driver = Drivers.getFirefoxDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitForMiddleButtonIsClickable();
        homePageScooter.scrollToMiddleButton();
        homePageScooter.clickToOrderMiddleButton();
        orderPageScooter.waitForOrderForm();
        orderPageScooter.clickToCook();
        orderPageScooter.fillOrderForm("дмитрий", "иванов", "Москава, Приморская 8", "Трубная", "9998887764");
        orderPageScooter.fillRentForm("04.12.2022", "сутки");
    }

    @Test
    public void testOrderPageChrome() {
        driver = Drivers.getChromeDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitForHeaderButtonIsClickable();
        homePageScooter.clickToOrderHeaderButton();
        orderPageScooter.waitForOrderForm();
        orderPageScooter.clickToCook();
        orderPageScooter.fillOrderForm("Евгения", "Сидорова", "Мира 6, кв 40", "Сокольники", "+79998887766");
        orderPageScooter.fillRentForm("11.12.2022", "трое суток");
    }

    @Test
    public void testOrderPageMiddleButtonChrome() {
        driver = Drivers.getChromeDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitForMiddleButtonIsClickable();
        homePageScooter.scrollToMiddleButton();
        homePageScooter.clickToOrderMiddleButton();
        orderPageScooter.waitForOrderForm();
        orderPageScooter.clickToCook();
        orderPageScooter.fillOrderForm("евгения", "сидорова", "Мира 6, кв 40", "Сокольники", "+7999888776");
        orderPageScooter.fillRentForm("11.12.2022", "трое суток");
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
