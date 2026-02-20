import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConstructorPageTest {
    private WebDriver driver;

    private String startTab;
    private String checkTab;
    private ConstructorPage constructorPage;

    private String attrClass = "class";
    private String valueCurrent = "tab_tab_type_current";

    @Parameterized.Parameters(name = "Активная вкладка перед тестом: {0}, проверяемая вкладка: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {ConstructorPage.tabSauces, ConstructorPage.tabBuns},
                {null,  ConstructorPage.tabSauces},
                {null,  ConstructorPage.tabFillings},
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
            WebElement tab = driver.findElement(ConstructorPage.tabParentDiv(startTab));
            constructorPage.clickTab(startTab);

            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.attributeContains(tab, attrClass, valueCurrent));
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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeContains(ConstructorPage.tabParentDiv(checkTab), attrClass, valueCurrent));

        assertEquals("Выбранная вкладка " + checkTab + " неактивна. Активна вкладка " + ConstructorPage.getActiveTab(),
                ConstructorPage.getActiveTab(), checkTab);

    }
}
