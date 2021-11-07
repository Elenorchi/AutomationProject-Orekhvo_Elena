package Lecture_9;

import Base.SauseDemo.BasketPage;
import Base.SauseDemo.CheckOutPage;
import Base.SauseDemo.LoginPage;
import driver.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {
    LoginPage logPage;
    BasketPage basketPage;
    CheckOutPage checkout;

    @BeforeClass
    public void precondition () {
        logPage = new LoginPage(driver);
        basketPage = new BasketPage (driver);
        checkout = new CheckOutPage(driver);
    }

    @Test
    public void loginOkUser() {
        logPage.open().Authorization("standard_user", "secret_sauce");
        Assert.assertTrue(logPage.productsDisplayed());
    }
    @Test
    public void loginLockedUser() {
        logPage.open().Authorization("locked_out_user", "secret_sauce");
        Assert.assertEquals(logPage.textOfError(), "Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    public void loginProblemUser() {
        logPage.open().Authorization("problem_user", "secret_sauce");
        Assert.assertTrue(logPage.WrongImgDisplayed());
    }
    @Test
    public void addingToBasket () {
        logPage.open().Authorization("standard_user", "secret_sauce");
        basketPage.addToBasket().openBasket();
        Assert.assertTrue(basketPage.removeBtnDisplayed());
    }
    @Test
    public void removingFromBasket () {
        logPage.open().Authorization("standard_user", "secret_sauce");
        basketPage.addToBasket().openBasket().removeProduct().continueShopping();
        Assert.assertTrue(basketPage.addingButtonDisplayed());
    }
    @Test
    public void checkingPayment () {
        logPage.open().Authorization("standard_user", "secret_sauce");
        basketPage.addToBasket().openBasket();
        checkout.goToCheckout().enterUserData().finishCheckout();
        Assert.assertTrue(checkout.succesfulBuying());
    }
}
