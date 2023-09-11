package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy (css = "[name='name']")
    WebElement playlistNameField;
    @FindBy (css = "div.success.show")
    WebElement renamePlaylistSuccessMsg;
    public void doubleClickPlaylist() {
        doubleClick((WebElement) firstPlaylist);
    }
    public void enterNewPlaylistName(String playlistName) {
        findElement((WebElement) playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement((WebElement) playlistNameField).sendKeys(playlistName);
        findElement((WebElement) playlistNameField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg() {
        return findElement((WebElement) renamePlaylistSuccessMsg).getText();
    }

}
