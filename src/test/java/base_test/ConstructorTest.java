package base_test;

import io.qameta.allure.Description;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Description("Тест проверяет работу кнопок конструктора на домашней странице")
    @Test
    public void constructorBunsTest() {
        constructor.goToUrlHomePageAndCheckUrl();
        constructor.checkBunsButton();
    }

    @Description("Тест проверяет работу кнопок конструктора на домашней странице")
    @Test
    public void constructorSaucesTest() {
        constructor.goToUrlHomePageAndCheckUrl();
        constructor.checkSaucesButton();
    }

    @Description("Тест проверяет работу кнопок конструктора на домашней странице")
    @Test
    public void constructorStuffingTest() {
        constructor.goToUrlHomePageAndCheckUrl();
        constructor.checkStuffingButton();
    }

}
