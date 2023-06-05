package base_page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import services.UserApiService;

import static base_page.common_constants.CommonConstants.HomePageConstants.MY_ACCOUNT_BUTTON;
import static base_page.common_constants.CommonConstants.LoginPageConstants.LOGIN_PAGE_URL;
import static base_page.common_constants.CommonConstants.PersonalCabinetConstants.CONSTRUCTOR_BUTTON;


public class PersonalCabinetPage extends BasePage {

    private final LoginPage loginPage = new LoginPage(driver);
    public static final String PERSONAL_CABINET_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final By EXIT_BUTTON = By.xpath("//button[contains(text(), 'Выход')]"); // кнопка выхода в личном кабинете

    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }


    @Step("Переход на страницу логина {LOGIN_PAGE_URL} ")
    public void goToURLLoginPage() {
        goToUrl(LOGIN_PAGE_URL);
    }

    @Step("Клик по кнопке Личный кабинет {MY_ACCOUNT_BUTTON} на главной странице и проверка перехода на страницу личного кабинета {PERSONAL_CABINET_URL}")
    public void personalCabinetClick() {
        clickElement(checkElementIsVisible(MY_ACCOUNT_BUTTON));
        assertCurrentUrlEquals(PERSONAL_CABINET_URL);
    }

    @Step("Клик на кнопку конструктор {CONSTRUCTOR_BUTTON} в личном кабинете и проверка перехода на домашнюю страницу {HOME_PAGE_URL}")
    public void clickToConstructorButton() {
        clickElement(checkElementIsClickable(CONSTRUCTOR_BUTTON));
        assertCurrentUrlEquals(HOME_PAGE_URL);
    }

    @Step("Клик на кнопку выход {EXIT_BUTTON} в личном кабинете и проверка перехода на домашнюю страницу {LOGIN_PAGE_URL}")
    public void clickToExitButton() {
        clickElement(checkElementIsClickable(EXIT_BUTTON));
        assertCurrentUrlEquals(LOGIN_PAGE_URL);
    }

    @Step("Ввод логина и пароля")
    public void loginAndPasswordInput() {
        loginPage.authorization();
    }

    @Step("Переход в личный кабинет")
    public void goToURLPersonalCabinet() {
        goToUrl(PERSONAL_CABINET_URL);
        assertCurrentUrlEquals(PERSONAL_CABINET_URL);
    }

    @Step("Переход в личный кабинет")
    public void goToURLHomePageAndCheckUrl() {
        goToUrl(HOME_PAGE_URL);
        assertCurrentUrlEquals(HOME_PAGE_URL);
    }

    @Step("Клик по кнопке Войти {MY_ACCOUNT_BUTTON} на странице логина и проверка перехода на страницу личного кабинета {PERSONAL_CABINET_URL}")
    public void enterButtonClickAndCheckUrl() {
        loginPage.enterButtonClick();
        assertCurrentUrlEquals(HOME_PAGE_URL);
    }

    @Step("Добавление accessToken и refreshToken в LocalStorage и обновление страницы")
    public void accessTokenSetup() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.localStorage.setItem('accessToken', arguments[0]);", UserApiService.getAccessToken());
        jsExecutor.executeScript("window.localStorage.setItem('refreshToken', arguments[0]);", UserApiService.getRefreshToken());
        driver.navigate().refresh();
    }

}
