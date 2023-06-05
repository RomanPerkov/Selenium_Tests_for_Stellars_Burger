package base_page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.UserApiService;

import static base_page.common_constants.CommonConstants.LoginPageConstants.LOGIN_PAGE_URL;
import static base_page.common_constants.CommonConstants.RegistrationAndLoginPageConstants.*;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private static final By INCORRECT_PASSWORD = By.xpath("//p[@class='input__error text_type_main-default']"); // надпись о некорректном пароле
    private static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";

    @Step("Переход на страницу регистрации")
    public void goToURLRegistrationPage() {
        goToUrl(REGISTRATION_URL);
    }

    @Step("Клик по кнопке Войти {ENTER_BUTTON} на странице регистрации и проверка перехода на страницу логина {LOGIN_PAGE_URL}")
    public void enterButtonClickAndCheckURL() {
        clickElement(checkElementIsVisible(ENTER_BUTTON));
        assertCurrentUrlEquals(LOGIN_PAGE_URL);
    }

    @Step("Заполнение полей  имени-{NAME_FIELD}  почтового адреса-{EMAIL_FIELD}  пароля-{PASSWORD_FIELD} на странице регистрации")
    public void fieldСompletion(boolean shortPassword) {
        UserApiService.fake = UserApiService.generateUser(shortPassword);
        clickElement(checkElementIsVisible(NAME_FIELD));
        checkElementIsVisible(NAME_FIELD).sendKeys(UserApiService.fake.get("name"));
        clickElement(checkElementIsVisible(EMAIL_FIELD));
        checkElementIsVisible(EMAIL_FIELD).sendKeys(UserApiService.fake.get("email"));
        clickElement(checkElementIsVisible(PASSWORD_FIELD));
        checkElementIsVisible(PASSWORD_FIELD).sendKeys(UserApiService.fake.get("password"));
    }

    @Step("Нажатие на кнопку регистрации -{REGISTRATION_BUTTON} , проверка перехода на страницу логина -{LOGIN_PAGE_URL}")
    public void enterRegistrationButton() {
        clickElement(checkElementIsVisible(REGISTRATION_BUTTON));
    }

    @Step("Проверка перехода на нужный URL {LOGIN_PAGE_URL}")
    public void toBeUrl() {
        assertCurrentUrlEquals(LOGIN_PAGE_URL);
    }

    @Step("Проверка появлении надписи о неправильном пароле {INCORRECT_PASSWORD}")
    public void wrongPasswordIsDisplayed() {
        checkElementIsVisible(INCORRECT_PASSWORD);
    }

}



