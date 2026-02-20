import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {

    private static WebDriver driver;

    public static String tabBuns = "Булки";
    public static String tabSauces = "Соусы";
    public static String tabFillings = "Начинки";

    public static final String URL_MAIN = "https://stellarburgers.education-services.ru";

    public ConstructorPage(WebDriver driver) {
        ConstructorPage.driver = driver;
    }

    //клик по вкладке конструктора
    public void clickTab(String sectionName) {
        driver.findElement(By.xpath("//span[text()='" + sectionName + "']")).click();
    }

    //получение названия активной вкладки
    public static String  getActiveTab() {
        return driver.findElement(By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span")).getText();
    }

    //получение родительского div
    public static By tabParentDiv(String startTab) {
        return By.xpath("//span[text()='" + startTab + "']/parent::div");
    }
}
