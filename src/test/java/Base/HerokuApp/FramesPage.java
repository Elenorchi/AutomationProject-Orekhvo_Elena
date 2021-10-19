package Base.HerokuApp;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FramesPage extends BasePage {

    private By iFrame = By.linkText("iFrame");
    private By frame = By.id("mce_0_ifr");
    private By body = By.xpath("//body[@class = 'mce-content-body ']");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTextField () {
        click(iFrame);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        Assert.assertEquals(getElementText(body), "Your content goes here.");
    }
}
