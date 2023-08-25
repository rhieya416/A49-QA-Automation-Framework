import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void navigateToPage() {
        driver.get(url);
    }
    public void emailInput(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void passwordInput(String password) {
       WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
       passwordField.clear();
       passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();
    }

}

