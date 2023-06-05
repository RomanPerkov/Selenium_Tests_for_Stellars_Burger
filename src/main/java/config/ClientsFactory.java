package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static config.Config.BROWSER_AND_PLATFORM;

/**
 * Фабрика клиентов в зависимости от установленной константы будет создаваться соответсвующий вебдрайвер
 */
public class ClientsFactory {

    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "YANDEX":
                ChromeOptions optionsYandex = new ChromeOptions();
                String yandexBrowserPath = System.getenv("YANDEX_BROWSER_PATH");
                if (yandexBrowserPath == null || yandexBrowserPath.isEmpty()) {
                    throw new RuntimeException("The environment variable for the yandex browser is not set , set the environment variable for the yandex browser.");
                }
                optionsYandex.setBinary(yandexBrowserPath);
                // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                optionsYandex.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(optionsYandex);
                break;
            default:
                Assert.fail("INCORECT BROWSER NAME " + BROWSER_AND_PLATFORM);
        }
        driver.manage().window().maximize();    // разворачивание окна браузера на весь экран
        return driver;
    }

}
