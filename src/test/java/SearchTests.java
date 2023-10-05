package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
public class SearchTests extends BaseTest {
    LoginPage loginPage;
    SearchPage searchPage;
    HomePage homePage;
    @Test
    public void addSongToPlaylistViaSearchField() {
        loginPage = new LoginPage(getThreadLocal());
        searchPage = new SearchPage(getThreadLocal());
        homePage = new HomePage(getThreadLocal());

        loginPage.loginWithCorrectCred();
        homePage.waitForLoadingBarToDisappear();
        searchPage.enterSongIntoSearchField()
                .clickViewAll()
                .clickOnSongTitle()
                .addTooBtn()
                .enterUniquePlaylist()
                .clickSubmitBtn()
                .selectFirstPlaylist();
        homePage.clickDeleteBtn();
        homePage.clickOk();
        searchPage.checkMsg();
    }
}