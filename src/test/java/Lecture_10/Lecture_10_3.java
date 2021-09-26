package Lecture_10;

import Base.BasketPage;
import Base.LoginPage;
import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_10_3 extends BaseTest {
    LoginPage log;
    BasketPage basket;

    @BeforeTest
    public void preconditions() {
        log = new LoginPage(driver);
        basket = new BasketPage(driver);
        log.open().Authorization("standard_user", "secret_sauce");
    }

    @Test
    public void test() {
        basket.sorting(BasketPage.sort.highToLow);
        basket.sorting(BasketPage.sort.lowToHigh);
        basket.sorting(BasketPage.sort.AtoZ);
        basket.sorting(BasketPage.sort.ZtoA);
    }
}
