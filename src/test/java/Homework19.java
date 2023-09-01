import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(3000);
        clickPlaylist();
        Thread.sleep(2000);
        clickDeletePlaylistBtn();
        Thread.sleep(2000);
        showSuccessMsg();
    }

    private void showSuccessMsg() {
        WebElement successMsg = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertTrue(successMsg.isDisplayed());
    }

    private void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylistBtn.click();
    }

    private void clickPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playlist.click();
    }
}
