import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public static final String URL_MAIN = "https://stellarburgers.education-services.ru";

    //Кнопка "Личный Кабинет"
    By buttonPersonalAccount = By.xpath("(//p[text()='Личный Кабинет'])");

    //Кнопка "Войти в аккаунт"
    By buttonLogInAccount = By.xpath("(//button[text()='Войти в аккаунт'])");

    //Кнопка "Оформить заказ"
    static By buttonCreateOrder = By.xpath("(//button[contains(text(), 'Оформить заказ')])");

    @Step("Клик по кнопке \"Личный Кабинет\"")
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("Клик по кнопке \"Войти в аккаунт\"")
    public void clickButtonLogInAccount() {
        driver.findElement(buttonLogInAccount).click();
    }
}
