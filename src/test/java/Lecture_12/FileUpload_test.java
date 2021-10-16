package Lecture_12;


import Base.HerokuApp.FileUploadPage;
import Base.HerokuApp.HomePageEnum;
import Base.HerokuApp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload_test extends BaseTest {
    HomePageObject homePage;
    FileUploadPage uploadPage;

    @BeforeTest
    public void preconditions() {
        homePage = new HomePageObject(driver);
        uploadPage = new FileUploadPage(driver);
        homePage.openPage().clickLink(HomePageEnum.FILE_UPLOAD);
    }
    @Test
    public void uploadTest () {
        uploadPage.uploadFile();
    }
}
