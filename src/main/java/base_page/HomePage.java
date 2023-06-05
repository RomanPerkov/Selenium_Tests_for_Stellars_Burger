package base_page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static base_page.common_constants.CommonConstants.HomePageConstants.MY_ACCOUNT_BUTTON;
import static base_page.common_constants.CommonConstants.LoginPageConstants.LOGIN_PAGE_URL;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By ENTER_ACCOUNT_BUTTON = By.xpath("//button[contains(text(),'Войти в аккаунт')]"); // локатор кнопки Войти в аккаунт на домашней странице

    @Step("Переход на домашнюю страницу")
    public void goToURLHomePageAndCheckUrl() {
        goToUrl(HOME_PAGE_URL);
        assertCurrentUrlEquals(HOME_PAGE_URL);
    }

    @Step("проверка видимости кнопки - {MY_ACCOUNT_BUTTON} , нажатие на нее и проверка перехода на страницу логина - {LOGIN_PAGE_URL}")
    public void accountButtonClick() {
        clickElement(checkElementIsVisible(MY_ACCOUNT_BUTTON));
        assertCurrentUrlEquals(LOGIN_PAGE_URL);
    }

    @Step("проверка видимости кнопки - {ENTER_ACCOUNT_BUTTON} и нажатие на нее, проверка перехода на страницу логина - {LOGIN_PAGE_URL}")
    public void enterAccountButton() {
        clickElement(checkElementIsVisible(ENTER_ACCOUNT_BUTTON));
        assertCurrentUrlEquals(LOGIN_PAGE_URL);
    }


}
