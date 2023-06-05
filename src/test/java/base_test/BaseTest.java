package base_test;

import base_page.PasswordRecoveryPage;
import base_page.Constructor;
import base_page.PersonalCabinetPage;
import base_page.RegistrationPage;
import base_page.HomePage;
import config.ClientsFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected final WebDriver driver = ClientsFactory.createDriver();
    protected final HomePage homePage = new HomePage(driver);
    protected final RegistrationPage registrationPage = new RegistrationPage(driver);
    protected final PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
    protected final PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
    protected final Constructor constructor = new Constructor(driver);

    @After
    public void closeDriver() {                // закрытие драйвера после теста
        if (driver != null) {
            driver.quit();
        }
    }
}
