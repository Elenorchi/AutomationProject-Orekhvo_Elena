package Lecture_12;

import Base.HerokuApp.ContextMenuPage;
import Base.HerokuApp.HomePageEnum;
import Base.HerokuApp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu_Test extends BaseTest {
    HomePageObject homePage;
    ContextMenuPage contextMenu;

    @BeforeTest
    public void preconditions() {
        homePage = new HomePageObject(driver);
        contextMenu = new ContextMenuPage(driver);
    }

    @Test
    public void contextTest() {
        homePage.openPage().clickLink(HomePageEnum.COMTEXT_MENU);
        contextMenu.verifyAlertText();
    }
}