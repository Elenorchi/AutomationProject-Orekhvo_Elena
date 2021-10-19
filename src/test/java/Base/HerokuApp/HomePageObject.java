package Base.HerokuApp;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private By title = By.tagName("h1");
    private By subtitle = By.tagName("h2");
    private By getLink (HomePageEnum HomePageEnum) {
        return By.linkText(HomePageEnum.getLinkText());
    }

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public HomePageObject openPage() {
        openPage("https://the-internet.herokuapp.com");
        return this;
    }
    public HomePageObject clickLink (HomePageEnum HomePageEnum ) {
        click(getLink(HomePageEnum));
        return this;
    }

}
