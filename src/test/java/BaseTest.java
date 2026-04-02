import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class BaseTest {
    public static WebDriver getDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        String os = System.getProperty("os.name").toLowerCase();

        if (browser.equals("yandex")) {
            ChromeOptions options = new ChromeOptions();
            if (os.contains("linux")) {
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver_y");
                options.setBinary("/usr/bin/yandex-browser");
            } else if (os.contains("win")) {
                options.setBinary("C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
            }
            return new ChromeDriver(options);
        } else { // Chrome
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}