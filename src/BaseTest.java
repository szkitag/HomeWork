import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static CloseableHttpClient client;

    WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(10000L));
    @BeforeAll
    static void WebdrivermanagerSetup() {
        System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
    }
    @BeforeAll
    static void WindowSetup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    @BeforeEach
    void DeleteCookies(){
        driver.manage().deleteAllCookies();
    }
    @BeforeMethod
    public static void startClient() {
        client = HttpClientBuilder.create().build();
    }
//    @AfterAll
//    public static void quitDriver(){
//        driver.quit();
//    }
}
