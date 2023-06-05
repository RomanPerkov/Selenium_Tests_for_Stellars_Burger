package base_test;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.UserApiService;

public class PersonalCabinetPageTest extends BaseTest {

    final UserApiService userApiService = new UserApiService();

    @Before
    public void createTestUser(){
        userApiService.createTestUser();
    }
    @After
    public void deleteTestUser(){
        userApiService.deleteTestUser();
    }

    @Description("Тест проверяет вход в личный кабинет")
    @Test
    public void goingToPersonalCabinetTest(){
        personalCabinetPage.goToURLLoginPage();
        personalCabinetPage.loginAndPasswordInput();
        personalCabinetPage.enterButtonClickAndCheckUrl();
        personalCabinetPage.personalCabinetClick();
    }


    @Description("Тест проверяет что совершается переход на домашнюю страницу при клике кнопки конструктора в личном кабинеет")
    @Test
    public void clickToConstructorTest(){
        personalCabinetPage.goToURLHomePageAndCheckUrl();
        personalCabinetPage.accessTokenSetup();
        personalCabinetPage.personalCabinetClick();
        personalCabinetPage.clickToConstructorButton();
    }

    @Description("Тест проверяет что совершается переход на домашнюю страницу при клике кнопки конструктора в личном кабинеет")
    @Test
    public void logoutTest(){
        personalCabinetPage.goToURLHomePageAndCheckUrl();
        personalCabinetPage.accessTokenSetup();
        personalCabinetPage.personalCabinetClick();
        personalCabinetPage.clickToExitButton();
    }
}
