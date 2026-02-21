import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class LoginPage {
    public static final String URL_LOGIN = "https://stellarburgers.education-services.ru/login";

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //поле "Email
    By fieldEmail = By.name("name");

    //поле "Пароль"
    By fieldPassword = By.name("Пароль");

    //кнопка "Войти"
    static By buttonLogIn = By.xpath("(//button[text()='Войти'])");

    //ссылка "Зарегистрироваться"
    By linkRegistration = By.linkText("Зарегистрироваться");

    //ссылка "Восстановить пароль"
    By linkForgotPassword = By.linkText("Зарегистрироваться");

    @Step("Клик по по полю \"Email\"")
    public void clickFieldEmail() {
        driver.findElement(fieldEmail).click();
    }

    @Step("Клик по полю \"Пароль\"")
    public void clickFieldPassword() {
        driver.findElement(fieldPassword).click();
    }

    @Step("Клик по кнопке \"Войти\"")
    public void clickButtonLogIn() {
        driver.findElement(buttonLogIn).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(MainPage.buttonCreateOrder));
    }

    @Step("Клик по ссылке \"Зарегистрироваться\"")
    public void clickLinkRegistration() {
        driver.findElement(linkRegistration).click();
    }

    @Step("Клик по ссылке \"Восстановить пароль\"")
    public void clickLinkForgotPassword() {
        driver.findElement(linkForgotPassword).click();
    }

    @Step("Заполнить поле \"Email\"")
    public void fillFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Заполнить поле \"Пароль\"")
    public void fillFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Проверка выполнения входа")
    public static void checkLogIn(WebDriver driver) {
        List<WebElement> elements = driver.findElements(MainPage.buttonCreateOrder);
        assertFalse("Кнопка оформления заказа не отображается - вход не выполнен " + System.getProperty("browser", "chrome"), elements.isEmpty());
    }

    @Step("Заполнение полей формы")
    public static void fillForm(LoginPage loginPage) {
        loginPage.clickFieldEmail();
        loginPage.fillFieldEmail(TestUser.email);
        loginPage.clickFieldPassword();
        loginPage.fillFieldPassword(TestUser.password);
    }
}
