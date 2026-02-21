import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class RegisterPage {

    public static final String URL_REGISTRATION = "https://stellarburgers.education-services.ru/register";

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //поле "Имя"
    By fieldName = By.xpath("(//input[@name='name'])[1]");

    //поле "Email"
    By fieldEmail = By.xpath("(//input[@name='name'])[2]");

    //поле "Пароль"
    By fieldPassword = By.name("Пароль");

    //кнопка "Зарегистрироваться"
    By buttonRegistration = By.xpath("(//button[text()='Зарегистрироваться'])[1]");

    //ссылка "Войти"
    By linkLogin = By.linkText("Войти");

    //ошибка пароля
    static By errorPassword = By.xpath("//p[contains(@class, 'input__error') and text()='Некорректный пароль']");

    @Step("Клик по полю \"Имя\"")
    public void clickFieldName() {
        driver.findElement(fieldName).click();
    }

    @Step("Клик по полю \"Email\"")
    public void clickFieldEmail() {
        driver.findElement(fieldEmail).click();
    }

    @Step("Клик по полю \"Пароль\"")
    public void clickFieldPassword() {
        driver.findElement(fieldPassword).click();
    }

    @Step("Клик по кнопке \"Зарегистрироваться\"")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Клик по ссылке \"Войти\"")
    public void clickLinkLogIn() {
        driver.findElement(linkLogin).click();
    }

    @Step("Заполнить поле \"Имя\"")
    public void fillFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    @Step("Заполнить поле \"Email\"")
    public void fillFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Заполнить поле \"Пароль\"")
    public void fillFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Ожидание перехода на страницу входа")
    public void waitingForLoginRedirect() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(LoginPage.buttonLogIn));
    }

    @Step("Ожидание появления ошибки пароля")
    public void waitingForPasswordError(By errorPassword) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(errorPassword));
    }

    @Step("Проверка успешной регистрации")
    public void checkRegistration() {
        assertTrue(driver.findElement(LoginPage.buttonLogIn).isDisplayed());
    }

    @Step("Проверка появления ошибки пароля")
    public void checkPasswordError() {
        assertTrue(driver.findElement(RegisterPage.errorPassword).isDisplayed());
    }
}
