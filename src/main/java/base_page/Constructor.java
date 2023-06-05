package base_page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Constructor extends BasePage {

    public Constructor(WebDriver driver) {
        super(driver);
    }


    final Actions actions = new Actions(driver);
    private static final By BUNS_BUTTON = By.xpath("//span[contains(text(),'Булки')]/..");
    private static final By SAUCES_BUTTON = By.xpath("//span[contains(text(),'Соусы')]/..");
    private static final By STUFFING_BUTTON = By.xpath("//span[contains(text(),'Начинки')]/..");
    private static final By BUNS_SECTION = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[1]");
    private static final By SAUCES_SECTION = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[2]");
    private static final By STUFFING_SECTION = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[3]");
    private static final String CSS_CLASS = "tab_tab_type_current__2BEPc"; // css класс по которому определяется выбрана ли кнопка


    @Step("Переход на домашнюю страницу - {url}")
    public void goToUrlHomePageAndCheckUrl() {
        goToUrl(HOME_PAGE_URL);
        assertCurrentUrlEquals(HOME_PAGE_URL);
    }

    @Step("Ожидание наличия класса {cssClass} у элемента {element}")
    public void waitForElementToHaveClass(By element, String cssClass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(element, "class", cssClass));
    }

    @Step("Проверка наличия класса {cssClass} у элемента {element}")
    public boolean checkElementHasClass(By element, String cssClass) {
        String classes = checkElementIsVisible(element).getAttribute("class");
        return !classes.contains(cssClass);
    }

    @Step("проверка {BUNS_BUTTON}")
    public void checkBunsButton() {
        if (checkElementHasClass(BUNS_BUTTON, CSS_CLASS)) {
            actions.moveToElement(driver.findElement(BUNS_BUTTON)).click().build().perform();
        }
        checkElementIsVisible(BUNS_SECTION);
    }

    @Step("проверка {SAUCES_BUTTON}")
    public void checkSaucesButton() {
        if (checkElementHasClass(SAUCES_BUTTON, CSS_CLASS)) {
            actions.moveToElement(driver.findElement(SAUCES_BUTTON)).click().build().perform();
            waitForElementToHaveClass(SAUCES_BUTTON, CSS_CLASS);
        }
        checkElementIsVisible(SAUCES_SECTION);
    }

    @Step("проверка {STUFFING_BUTTON}")
    public void checkStuffingButton() {
        if (checkElementHasClass(STUFFING_BUTTON, CSS_CLASS)) {
            actions.moveToElement(driver.findElement(STUFFING_BUTTON)).click().build().perform();
            waitForElementToHaveClass(STUFFING_BUTTON, CSS_CLASS);
        }
        checkElementIsVisible(STUFFING_SECTION);
    }


}
