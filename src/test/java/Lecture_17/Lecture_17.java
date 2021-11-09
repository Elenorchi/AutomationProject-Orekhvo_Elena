package Lecture_17;

import Base.MoodPanda.BaseTest_MoodPanda;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

/*
Автоматизация тестирования проекта https://moodpanda.com/ с помощью
Selenide и использованием практик наработанных ранее
a. * (с зорачкай) Создать чеклист
b. В каждом автотесте писать description с названием проверки
c. Написать минимум 3 теста
 */

public class Lecture_17 extends BaseTest_MoodPanda {

    @Test(description = "Checking START button")
    public void firstTest() {
        getPage(PageObjectSelenide.class).verifyStartBtn();
    }

    @Test(description = "Checking TESTIMONIALS button")
    public void secondTest() {
        getPage(PageObjectSelenide.class).verifyTestimonialsBtn();
    }

    @Test(description = "Checking FAQ button + scroll")
    public void thirdTest() {
        getPage(PageObjectSelenide.class).verifyFAQ();
    }

    @AfterMethod
    public void postCondition() {
        closeWebDriver();
    }
}

