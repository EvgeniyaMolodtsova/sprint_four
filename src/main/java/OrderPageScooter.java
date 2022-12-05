import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageScooter {
    private final WebDriver driver;

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // ожидание загрузки формы заказа
    public void waitForOrderForm() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(By.className("Order_Header__BZXOb")).getText() != null && !driver.findElement(By.className("Order_Header__BZXOb")).getText().isEmpty()));
    }

    // поле "Имя"
    private final By orderName = By.xpath(".//input[@placeholder='* Имя']");

    // поле "Фамилия"
    private final By orderLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле "Адрес"
    private final By orderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле "Метро"
    private final By orderMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // поле "Номер телефона"
    private final By orderUserPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // поле "Дата, когда привезти самокат"
    private final By orderDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // поле "длительность аренды"
    private final By leaseDuration = By.className("Dropdown-arrow");

    // кнопка "Далее"
    private final By buttonNext = By.className("Button_Middle__1CSJM");

    // кнопка "Закать" после введения данных
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // кнопка согласия с куками
    private final By buttonCook = By.className("App_CookieButton__3cvqF");

    // кнопка "Да" для завершения заказа
    private final By buttonYes = By.xpath(".//button[text()='Да']");

    // заголовок окна успешного завершения заказа
    private final By successfulOrder = By.xpath(".//div[text()='Заказ оформлен']");

    public void setUserName(String username) {
        driver.findElement(orderName).sendKeys(username);
    }

    public void setLastName(String userLastName) {
        driver.findElement(orderLastName).sendKeys(userLastName);
    }

    public void setOrderAddress(String userOrderAddress) {
        driver.findElement(orderAddress).sendKeys(userOrderAddress);
    }

    public void setMetroStation(String userMetroStation) {
        driver.findElement(orderMetroStation).sendKeys(userMetroStation);
        driver.findElement(By.className("Order_Text__2broi")).click();
    }

    public void setPhoneNumber(String userPhoneNumber) {
        driver.findElement(orderUserPhoneNumber).sendKeys(userPhoneNumber);
    }

    public void clickToButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void clickToCook() {
        driver.findElement(buttonCook).click();
    }

    public void orderIsSuccessful() {
        driver.findElement(successfulOrder);
    }

    public void fillOrderForm(String username, String userLastName, String userOrderAddress, String userMetroStation, String userPhoneNumber) {
        setUserName(username);
        setLastName(userLastName);
        setOrderAddress(userOrderAddress);
        setMetroStation(userMetroStation);
        setPhoneNumber(userPhoneNumber);
        clickToButtonNext();
    }

    public void setOrderDate(String date) {
        driver.findElement(orderDate).sendKeys(date);
    }

    public void setLeaseDuration(String duration) {
        String xpath = ".//div[(@class='Dropdown-option' and text()='" + duration + "')]";
        driver.findElement(leaseDuration).click();
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public void fillRentForm(String date, String duration) {
        setOrderDate(date);
        setLeaseDuration(duration);
        clickButtonOrder();
        clickButtonYes();
        orderIsSuccessful();

    }
}
