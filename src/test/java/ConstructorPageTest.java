import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class ConstructorPageTest {
    private WebDriver driver;

    private String startTab;
    private String checkTab;
    private ConstructorPage constructorPage;


    @Parameterized.Parameters(name = "Активная вкладка перед тестом: {0}, проверяемая вкладка: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {ConstructorPage.tabSauces, ConstructorPage.tabBuns},
                {null, ConstructorPage.tabSauces},
                {null, ConstructorPage.tabFillings},
        };
    }

    public ConstructorPageTest(String startTab, String checkTab) {
        this.startTab = startTab;
        this.checkTab = checkTab;
    }

    @Before
    public void runBrowser() {
        driver = BaseTest.getDriver();

        driver.get(ConstructorPage.URL_MAIN);
        constructorPage = new ConstructorPage(driver);
        if (startTab != null) {
            constructorPage.clickTab(startTab);
        }
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка выбора раздела конструктора ")
    @Description("При переходе на вкладку она должна стать активной")
    public void transitionToTabIsWorkTest() {
        constructorPage.clickTab(checkTab);
        constructorPage.checkActiveTabName(checkTab);
    }
}
