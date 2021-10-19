package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 5);
    }

    protected void enter(By element, CharSequence... charSequences) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void openPage(String url) {
        driver.get(url);
    }

    protected String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    protected boolean display(By element) {
        return driver.findElement(element).isDisplayed();
    }

}
