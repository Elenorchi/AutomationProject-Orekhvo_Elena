package Base.SauseDemo;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    protected By checkoutBtn = By.id("checkout");
    protected By firstName = By.id("first-name");
    protected By lastName = By.id("last-name");
    protected By zipCode = By.id("postal-code");
    protected By continueBtn = By.id("continue");
    protected By finish = By.id("finish");
    protected By succesfulBuy = By.className("complete-header");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage goToCheckout() {
        click(checkoutBtn);
        return this;
    }

    public CheckOutPage enterUserData() {
        enter(firstName, "Elena");
        enter(lastName, "Arekhva");
        enter(zipCode, "222164");
        click(continueBtn);
        return this;
    }

    public CheckOutPage finishCheckout() {
        click(finish);
        return this;
    }
    public boolean succesfulBuying () {
        return display(succesfulBuy);
    }
}
