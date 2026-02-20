import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    By errorPassword = By.xpath("//p[contains(@class, 'input__error') and text()='Некорректный пароль']");

    //клик по полю "Имя"
    public void clickFieldName() {
        driver.findElement(fieldName).click();
    }

    //клик по полю "Email"
    public void clickFieldEmail() {
        driver.findElement(fieldEmail).click();
    }

    //клик по полю "Пароль"
    public void clickFieldPassword() {
        driver.findElement(fieldPassword).click();
    }

    //клик по кнопке "Зарегистрироваться"
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    //клик по ссылке "Войти"
    public void clickLinkLogIn() {
        driver.findElement(linkLogin).click();
    }

    //заполнить поле "Имя"
    public void fillFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
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
