package Lecture_17;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PageObjectSelenide {

    public void verifyStartBtn() {
        $(byText("Start")).shouldBe(visible).click();
        $(withText("Login to MoodPanda")).shouldBe(visible);
    }
    public void verifyTestimonialsBtn () {
        $(byXpath("//a[contains( text (),'Testimonials')]")).click();
        $(withText("Wonderful")).shouldBe(visible);
    }
    public void verifyFAQ() {
        $(withText("FAQs")).shouldBe(visible).click();
        ($(withText("I have more questions"))).scrollTo().shouldBe(visible);
    }




}
