import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    void setup(){
        loginPage = new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
    }
    @Test
    public void validPassword() throws InterruptedException {
        loginPage.loginCorrectCred();
    }
    @Test
    public void validLoginPassword() {
        loginPage.loginCorrectCred();
    }

}
