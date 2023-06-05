package base_test;

import io.qameta.allure.Description;
import org.junit.Test;

public class PasswordRecoveryPageTest extends BaseTest {

    @Description("Тест проверяет переход на страницу логина со страницы восстановления пароля")
    @Test
    public void enterButtonTest() {
        passwordRecoveryPage.goToURLPasswordRecoveryPage();
        passwordRecoveryPage.enterButtonClickAndChekUrl();
    }

}
