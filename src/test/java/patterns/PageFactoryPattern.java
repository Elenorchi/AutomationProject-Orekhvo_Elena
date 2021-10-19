package patterns;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryPattern extends BasePage {

    public PageFactoryPattern(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-button")
    WebElement logIn;

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    public void login () {
        openPage ("https://www.saucedemo.com");
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        logIn.click();
    }
    public void print(UserBuilder user) {
        System.out.println(user.age);
        System.out.println(user.username);
        System.out.println(user.email);
    }
    public void printValue(User user) {
        System.out.println(user.age);
        System.out.println(user.username);
        System.out.println(user.email);
    }
}
