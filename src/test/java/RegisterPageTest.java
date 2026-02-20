import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class RegisterPageTest {
    private WebDriver driver;

    @Before
    public void runBrowser() {
        driver = BaseTest.getDriver();
        driver.get(RegisterPage.URL_REGISTRATION);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Проверка успешной регистрации уникального пользователя")
    public void registrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickFieldName();
        registerPage.fillFieldName("Иветти");

        registerPage.clickFieldEmail();
        registerPage.fillFieldEmail("iv" + System.currentTimeMillis() + "@yandex.ru");

        registerPage.clickFieldPassword();
        registerPage.fillFieldPassword("1q2w3e4r");

        registerPage.clickButtonRegistration();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(LoginPage.buttonLogIn));
        assertTrue(driver.findElement(LoginPage.buttonLogIn).isDisplayed());
    }

    @Test
    @DisplayName("Тест длины пароля")
    @Description("Проверка возникновения ошибки при слишком коротком пароле")
    public void cannotRegisterWithShortPasswordTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickFieldName();
        registerPage.fillFieldName("Леонидас");

        registerPage.clickFieldEmail();
        registerPage.fillFieldEmail("leo" + System.currentTimeMillis() + "@yandex.ru");

        registerPage.clickFieldPassword();
        registerPage.fillFieldPassword("1q2w3");

        registerPage.clickButtonRegistration();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(registerPage.errorPassword));
        assertTrue(driver.findElement(registerPage.errorPassword).isDisplayed());
    }
}
