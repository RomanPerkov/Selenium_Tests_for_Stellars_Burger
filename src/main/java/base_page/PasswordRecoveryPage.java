package base_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static base_page.common_constants.CommonConstants.LoginPageConstants.LOGIN_PAGE_URL;
import static base_page.common_constants.CommonConstants.RegistrationAndLoginPageConstants.ENTER_BUTTON;


public class PasswordRecoveryPage extends BasePage {

    private static final String PASSWORD_RECOVERY_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу {PASSWORD_RECOVERY_PAGE} восстановления пароля")
    public void goToURLPasswordRecoveryPage() {
        goToUrl(PASSWORD_RECOVERY_PAGE);
    }

    @Step("Клик по кнопке Войти {ENTER_BUTTON} на странице восстановления пароля и проверка перехода на страницу логина {LOGIN_PAGE_URL}")
    public void enterButtonClickAndChekUrl() {
        clickElement(checkElementIsVisible(ENTER_BUTTON));
        assertCurrentUrlEquals(LOGIN_PAGE_URL);
    }
}
