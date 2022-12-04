import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Drivers {
    public static WebDriver getChromeDriver() {
        // уставливаем путь до локального драйвера хрома
        System.setProperty("webdriver.chrome.driver", "/Users/pingvina/WebDriver/bin/chromedriver");

        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");


        return new ChromeDriver(options);
    }

    public static WebDriver getFirefoxDriver() {
        // уставливаем путь до локального драйвера firefox
        System.setProperty("webdriver.gecko.driver", "/Users/pingvina/WebDriver/bin/geckodriver");

        // драйвер для браузера Firefox
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        return new FirefoxDriver(options);
    }
}