package base_test;

import io.qameta.allure.Description;
import org.junit.Test;

public class HomePageTest extends BaseTest {



    @Description("Тест проверяет происходит ли переход на страницу логина при нажатии на кнопку Личный кабинет")
    @Test
    public void loginButtonTest() {
        homePage.goToURLHomePageAndCheckUrl();
        homePage.accountButtonClick();

    }

    @Description("Тест проверяет происходит ли переход на страницу логина при нажатии на кнопку Войти в аккаунт")
    @Test
    public void enterAccountButtonTest() {
        homePage.goToURLHomePageAndCheckUrl();
        homePage.enterAccountButton();

    }


}
