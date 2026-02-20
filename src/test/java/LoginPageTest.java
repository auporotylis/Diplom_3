import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.junit.Assert.assertFalse;


public class LoginPageTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        TestUser.createTestUser();
    }

    @Before
    public void runBrowser() {
        driver = BaseTest.getDriver();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка успешного входа через кнопку «Войти в аккаунт»")
    public void loginByButtonLogInTest() {
        driver.get(MainPage.URL_MAIN);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickButtonLogInAccount();

        fillForm(loginPage);
        checkLogIn();
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет»")
    @Description("Проверка успешного входа через кнопку «Личный кабинет»")
    public void loginByButtonPersonalAccountTest() {
        driver.get(MainPage.URL_MAIN);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickButtonPersonalAccount();

        fillForm(loginPage);
        checkLogIn();
    }

    @Test
    @DisplayName("Вход по ссылке «Войти» в форме регистрации")
    @Description("Проверка успешного входа через ссылку «Войти» в форме регистрации")
    public void loginByLinkLogInFromRegisterFormTest() {
        driver.get(LoginPage.URL_LOGIN);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLinkRegistration();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLinkLogIn();

        fillForm(loginPage);
        checkLogIn();
    }

    @Test
    @DisplayName("Вход по ссылке «Войти» в форме восстановления пароля")
    @Description("Проверка успешного входа через ссылку «Войти» в форме восстановления пароля")
    public void loginByLinkLogInFromForgotPasswordTest() {
        driver.get(LoginPage.URL_LOGIN);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLinkForgotPassword();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLinkLogIn();

        fillForm(loginPage);
        checkLogIn();
    }


    @Step("Заполнение полей формы")
    private void fillForm(LoginPage loginPage) {
        loginPage.clickFieldEmail();
        loginPage.fillFieldEmail(TestUser.email);
        loginPage.clickFieldPassword();
        loginPage.fillFieldPassword(TestUser.password);
        loginPage.clickButtonLogIn();
    }

    @Step("Проверка входа")
    public void checkLogIn() {
        List<WebElement> elements = driver.findElements(MainPage.buttonCreateOrder);
        assertFalse("Кнопка оформления заказа не отображается - вход не выполнен " + System.getProperty("browser", "chrome"), elements.isEmpty());
    }
}
