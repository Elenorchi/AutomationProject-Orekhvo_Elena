package Lecture_10_11;

import Base.SauseDemo.BasketPage;
import Base.SauseDemo.LoginPage;
import driver.BaseTest;
import driver.Listener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class Lecture_10_3 extends BaseTest {
    LoginPage log;
    BasketPage basket;

    @BeforeTest
    public void preconditions() {
        log = new LoginPage(driver);
        basket = new BasketPage(driver);
        log.open().Authorization("standard_user", "secret_sauce");
    }

    @Test (description = "Проверка сортировки")
    public void testSort() {
        basket.sorting(BasketPage.sort.highToLow);
        basket.sorting(BasketPage.sort.lowToHigh);
        basket.sorting(BasketPage.sort.AtoZ);
        basket.sorting(BasketPage.sort.ZtoA);
    }
}
