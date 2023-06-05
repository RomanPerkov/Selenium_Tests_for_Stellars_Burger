package base_test;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;
import services.UserApiService;

public class RegistrationPageTest extends BaseTest {

    final UserApiService userApiService = new UserApiService();

    @After
    public void deleteTestUser(){
        userApiService.deleteTestUser();
    }


    @Description("Тест проверяет переход на страницу логина со страницы регистрации")
    @Test
    public void enterButtonTest(){
        registrationPage.goToURLRegistrationPage();
        registrationPage.enterButtonClickAndCheckURL();
    }

    @Description("Тест проверяет регистрацию нового пользователя")
    @Test
    public void registrationTest(){
        registrationPage.goToURLRegistrationPage();
        registrationPage.fieldСompletion(false); //используем корректный пароль
        registrationPage.enterRegistrationButton();
        registrationPage.toBeUrl();
    }

    @Description("Тест проверяет ошибку для некорректного пароля (меньше 6 символов)")
    @Test
    public void incorrectPasswordRegistartionTest(){
        registrationPage.goToURLRegistrationPage();
        registrationPage.fieldСompletion(true);  // используем некорректный пароль() меньше 6 символов
        registrationPage.enterRegistrationButton();
        registrationPage.wrongPasswordIsDisplayed();
    }
}
