import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //ссылка "Войти"
    By linkLogIn = By.xpath("//a[contains(text(), 'Войти')]");

    @Step("Клик по ссылке \"Войти\"")
    public void clickLinkLogIn() {
        driver.findElement(linkLogIn).click();
    }
}
