package base_page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.UserApiService;

import static base_page.common_constants.CommonConstants.RegistrationAndLoginPageConstants.EMAIL_FIELD;
import static base_page.common_constants.CommonConstants.RegistrationAndLoginPageConstants.PASSWORD_FIELD;

public class LoginPage extends HomePage {

    public static final By ENTER_LOGIN_BUTTON = By.xpath("//button[contains(text(), 'Войти')]");// кнопка войти на странице логина

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод данных для авторизации")
    public void authorization() {
        clickElement(checkElementIsVisible(EMAIL_FIELD));
        checkElementIsVisible(EMAIL_FIELD).sendKeys(UserApiService.fake.get("email"));
        clickElement(checkElementIsVisible(PASSWORD_FIELD));
        checkElementIsVisible(PASSWORD_FIELD).sendKeys(UserApiService.fake.get("password"));
    }

    @Step("Клик по кнопке войти - {ENTER_LOGIN_BUTTON} на странице логина")
    public void enterButtonClick() {
        clickElement(checkElementIsClickable(ENTER_LOGIN_BUTTON));
    }
}
