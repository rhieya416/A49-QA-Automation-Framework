import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String songAddedNotification = "Added 1 song to \"Test Pro Playlist.\"";

        navigateToPage();
        emailInput("demo@class.com");
        passwordInput("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("Pluto");
        clickViewAllBtn();
        firstSongResult();
        clickAddToBtn();
        createNewPlaylist();

        Assert.assertEquals(getAddToPlaylistSuccessMsg(), songAddedNotification);
    }
    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void firstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector(".search-results .song-item .title"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }
    public void createNewPlaylist() throws InterruptedException {
        WebElement newPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')"));
        newPlaylist.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
