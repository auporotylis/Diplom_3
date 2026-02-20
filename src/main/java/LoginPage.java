import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    //клик по полю "Email"
    public void clickFieldEmail() {
        driver.findElement(fieldEmail).click();
    }

    //клик по полю "Пароль"
    public void clickFieldPassword() {
        driver.findElement(fieldPassword).click();
    }

    //клик по кнопке "Войти"
    public void clickButtonLogIn() {
        driver.findElement(buttonLogIn).click();
    }

    //клик по ссылке "Восстановить пароль"
    public void clickLinkRegistration() {
        driver.findElement(linkRegistration).click();
    }

    //клик по ссылке "Зарегистрироваться"
    public void clickLinkForgotPassword() {
        driver.findElement(linkForgotPassword).click();
    }

    //заполнить поле "Email"
    public void fillFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    //заполнить поле "Пароль"
    public void fillFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

}
