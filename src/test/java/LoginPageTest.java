import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        Response response = TestUser.createTestUser();
        TestUser.checkCreateUserStatus(response);
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
        LoginPage.fillForm(loginPage);
        loginPage.clickButtonLogIn();
        LoginPage.checkLogIn(driver);
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет»")
    @Description("Проверка успешного входа через кнопку «Личный кабинет»")
    public void loginByButtonPersonalAccountTest() {
        driver.get(MainPage.URL_MAIN);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickButtonPersonalAccount();
        LoginPage.fillForm(loginPage);
        loginPage.clickButtonLogIn();
        LoginPage.checkLogIn(driver);
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

        LoginPage.fillForm(loginPage);
        loginPage.clickButtonLogIn();
        LoginPage.checkLogIn(driver);
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

        LoginPage.fillForm(loginPage);
        loginPage.clickButtonLogIn();
        LoginPage.checkLogIn(driver);
    }
}
