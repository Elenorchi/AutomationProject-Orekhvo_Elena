package Base.MoodPanda;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.Configuration.browserSize;

public class BaseTest_MoodPanda {
    String url = "https://www.moodpanda.com/";

    public <Type> Type getPage(Class<Type> pageObjectClassClass) {
        browserSize = "1800x1000";
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(url, pageObjectClassClass);

    }


}
