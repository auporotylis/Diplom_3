import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ConstructorPage {

    private WebDriver driver;

    public static String tabBuns = "Булки";
    public static String tabSauces = "Соусы";
    public static String tabFillings = "Начинки";
    public static final String URL_MAIN = "https://stellarburgers.education-services.ru";

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    //вкладка конструктора
    public By tab(String sectionName) {
        return By.xpath("//span[text()='" + sectionName + "']");
    }

    //активная вкладка конструктора
    public static By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span");

    @Step("Клик по вкладке конструктора")
    public void clickTab(String sectionName) {
        driver.findElement(tab(sectionName)).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(activeTab, sectionName));
    }

    @Step("Получение названия активной вкладки")
    public String getActiveTab() {
        return driver.findElement(activeTab).getText();
    }

    @Step("Проверка названия активной вкладки")
    public void checkActiveTabName(String checkTabName) {
        assertEquals("Выбранная вкладка " + checkTabName + " неактивна. Активна вкладка " +  getActiveTab(),
                checkTabName,  getActiveTab());
    }
}
