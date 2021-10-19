package Lecture_12;

import Base.HerokuApp.FramesPage;
import Base.HerokuApp.HomePageEnum;
import Base.HerokuApp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames_test  extends BaseTest {
    HomePageObject homePage;
    FramesPage frame;


    @BeforeTest
    public void preconditions() {
        homePage = new HomePageObject(driver);
        frame = new FramesPage(driver);
        homePage.openPage().clickLink(HomePageEnum.FRAMES);
    }

    @Test
    public void framesTest () {
        frame.verifyTextField();
    }
}
