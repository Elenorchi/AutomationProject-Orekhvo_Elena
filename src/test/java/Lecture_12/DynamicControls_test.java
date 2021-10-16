package Lecture_12;


import Base.HerokuApp.DynamicControlsPage;
import Base.HerokuApp.HomePageEnum;
import Base.HerokuApp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControls_test extends BaseTest {
    HomePageObject homePage;
    DynamicControlsPage dynamicControlPage;

    @BeforeTest
    public void preconditions() {
        homePage = new HomePageObject(driver);
        dynamicControlPage = new DynamicControlsPage (driver);
        homePage.openPage().clickLink(HomePageEnum.DYNAMIC_CONTROLS);
    }

    @Test
    public void checkboxTest () {
        dynamicControlPage.verifyCheckbox();
    }
    @Test
    public void inputTest () {
        dynamicControlPage.verifyInput();
    }
}
