package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
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
