package base_page.common_constants;

import org.openqa.selenium.By;

public class CommonConstants {

    public static class HomePageConstants {

        public static final By MY_ACCOUNT_BUTTON = By.xpath("//a[@href='/account']"); // локатор кнопки Личный кабинет на домашней страницу
    }

    public static class RegistrationAndLoginPageConstants {
        public static final By NAME_FIELD = By.xpath("//label[contains(text(), 'Имя')]/following-sibling::input"); // поле имени
        public static final By EMAIL_FIELD = By.xpath("//label[contains(text(), 'Email')]/following-sibling::input"); // поле почтового адреса
        public static final By PASSWORD_FIELD = By.xpath("//label[contains(text(), 'Пароль')]/following-sibling::input"); // поле пароля
        public static final By REGISTRATION_BUTTON = By.xpath("//button[contains(text(), 'Зарегистрироваться')]"); // кнопка регистрации
        public static final By ENTER_BUTTON = By.xpath("//a[contains(text(), 'Войти')]");//локатор для кнопки войти на страницах регистрации и восстановления пароля

    }

    public static class LoginPageConstants {
        public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";//адрес страницы авторизации
    }

    public static class PersonalCabinetConstants {
        public static final By CONSTRUCTOR_BUTTON = By.xpath("//p[contains(text(), 'Конструктор')]");//локатор для кнопки войти на страницах регистрации и восстановления пароля

    }


}



