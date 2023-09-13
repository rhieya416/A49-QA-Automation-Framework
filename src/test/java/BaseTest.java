import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public class BaseTest {
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getThreadDriver() {
        return threadDriver.get();
    }
    public WebDriver driver;
    public String url = "https://qa.koel.app/";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        threadDriver.set(setupBrowser(!(System.getProperty("browser")==null)?System.getProperty("browser"):"chrome"));
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadDriver());
    }
    private WebDriver setupBrowser(String browser) throws MalformedURLException{
        switch (browser) {
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "cloud":
                return setupLambda();
            default:
                return setupChrome();
        }
    }

    WebDriver setupLambda() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("117.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "maria.ogden");
        ltOptions.put("accessKey", "pEXo4Hd56hdUz46R7UDxrBPbtYH1EJk7gt6idpBSY4llyT6Ejp");
        ltOptions.put("project", "TestPro");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL),browserOptions);
    }

    WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }
    @AfterClass
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }
}