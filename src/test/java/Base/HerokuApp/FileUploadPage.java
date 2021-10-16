package Base.HerokuApp;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUploadPage extends BasePage {

    private By uploader = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By uploadedFiles = By.id ("uploaded-files");
    String link = "C:\\Users\\AutomationProject-Orekhvo_Elena\\src\\test\\java\\Lecture_12\\file.png";


    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile() {
        driver.findElement(uploader).sendKeys(link);
        click(uploadBtn);
        Assert.assertEquals(getElementText(uploadedFiles),"file.png");
    }
}
