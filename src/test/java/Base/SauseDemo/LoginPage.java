package Base.SauseDemo;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By user = By.id("user-name");
    private By password = By.id("password");
    private By logButton = By.id("login-button");
    private String url = "https://www.saucedemo.com";
    private By error = By.cssSelector("[data-test ='error']");
    private By wrongImg = By.xpath("//*[@src = '/static/media/sl-404.168b1cce.jpg']");
    private By products = By.xpath("//*[.='Products']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        openPage(this.url);
        return this;
    }

    public LoginPage enterUser(String user) {
        enter(this.user, user);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage login() {
        click(logButton);
        return this;
    }

    public LoginPage Authorization(String user, String password) {
        enter(this.user, user);
        enter(this.password, password);
        click(this.logButton);
        return this;
    }

    public String textOfError() {
        return getElementText(error);
    }
    public boolean WrongImgDisplayed () {
        return display(wrongImg);
    }
    public boolean productsDisplayed () {
        return display(products);
    }
}

