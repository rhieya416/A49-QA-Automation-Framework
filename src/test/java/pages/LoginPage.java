package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Fluent interface
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        click(submitBtn);
    }
}
