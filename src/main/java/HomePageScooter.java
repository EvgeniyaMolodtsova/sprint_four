import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    private WebDriver driver;
    // кнопка "Заказать" в шапке страницы
    private By orderHeaderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // кнопка "Заказать" в середине страницы
    private By orderMiddleButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Загаловок блока "Вопросы о важном"
    private By importantQuestionsHeader = By.className("Home_SubHeader__zwi_E");

    // кнопка принятия куков
    private By buttonCook = By.className("App_CookieButton__3cvqF");

    // массив ответов блока Вопросов о важном
    private String[] expectedTexts = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // ожидание кликабельности кнопки "Заказать" в шапке
    public void waitForHeaderButtonIsClickable() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderHeaderButton));
    }

    // ожидание кликабельности кнопки "Заказать" в середине
    public void waitForMiddleButtonIsClickable() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderMiddleButton));
    }

    // ожидание прогрузки заголовка "Вопросы о важном"
    public void waitForImportantQuestionsIsRendered() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(importantQuestionsHeader).getText() != null
                && !driver.findElement(importantQuestionsHeader).getText().isEmpty()
        ));
    }

    public void clickToCook() {
        driver.findElement(buttonCook).click();
    }

    public void clickToOrderHeaderButton() {
        driver.findElement(orderHeaderButton).click();
    }

    public void clickToOrderMiddleButton() {
        driver.findElement(orderMiddleButton).click();
    }

    public void scrollToImportantQuestions() {
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToMiddleButton() {
        WebElement element = driver.findElement(orderMiddleButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void checkNodeInImportantQuestions(int index, String expectedText) {
        driver.findElement(By.id("accordion__heading-" + index)).click();

        String text = driver.findElement(By.id("accordion__panel-" + index)).getText();

        Assert.assertEquals(expectedText, text);
    }



    public void checkImportantQuestions() {
        scrollToImportantQuestions();

        for (int i = 0; i < expectedTexts.length; i++) {
            System.out.println(i);
            checkNodeInImportantQuestions(i, expectedTexts[i]);
        }
    }
}
