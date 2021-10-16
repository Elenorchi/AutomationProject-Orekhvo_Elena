package Base.HerokuApp;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {
    private By checkbox = By.id("checkbox");
    private By removeBtn = By.xpath("//button[text()='Remove']");
    private By message = By.id("message"); // ?????????
    private By input = By.xpath("//input");
    private By enableBtn = By.xpath("//button[text()='Enable']");
    private By disableBtn = By.xpath("//button[text()='Disable']");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsPage verifyCheckbox() {
        Assert.assertTrue (display(checkbox));
        click(removeBtn);
        wait.until(ExpectedConditions.textToBe(message, "It's gone!"));
        //Assert.assertEquals(getElementText(message), "It's gone!");
        return this;
    }

    public DynamicControlsPage verifyInput() {
        Assert.assertTrue (display(input));
        Assert.assertEquals(getElementText(enableBtn), "Enable");
        click (enableBtn);
        Assert.assertEquals(driver.findElements(checkbox).size(),0);
        wait.until(ExpectedConditions.textToBe(message, "It's enabled!"));
        Assert.assertTrue (display(disableBtn));
        return this;
    }
}
