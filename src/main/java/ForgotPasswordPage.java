import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //ссылка "Войти"
    By linkLogIn = By.xpath("//a[contains(text(), 'Войти')]");

    //клик по ссылке "Зарегистрироваться"
    public void clickLinkLogIn() {
        driver.findElement(linkLogIn).click();
    }
}
