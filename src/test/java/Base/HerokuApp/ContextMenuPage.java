package Base.HerokuApp;

import Base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {
    private By hotspot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
    public ContextMenuPage verifyAlertText () {
        action.contextClick(driver.findElement(hotspot)).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText() ,"You selected a context menu");
        alert.accept();
        return this;
    }
}
