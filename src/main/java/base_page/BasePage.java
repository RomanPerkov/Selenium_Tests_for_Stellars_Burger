package base_page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {


    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site/"; // адрес домашней страницы приложения


    @Step("Переход по URL - {url}")
    public void goToUrl(String url) {
        driver.get(url);
    }

    @Step("Клик по элементу - {element}")
    public void clickElement(WebElement element) {
        element.click();
    }

    @Step("Ожидание появления элемента - {element}")
    public WebElement checkElementIsVisible(By element) {
        return (new WebDriverWait(driver, Duration.ofSeconds(10))).
                until((ExpectedConditions.visibilityOfElementLocated(element)));
    }

    @Step("Проверка кликабельности элемента")
    public WebElement checkElementIsClickable(By element) {
        return (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    @Step("Проверка перехода на нужный URL - {expectedUrl}")
    public void assertCurrentUrlEquals(String expectedUrl) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));
    }


}
