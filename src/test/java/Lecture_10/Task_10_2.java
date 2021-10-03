package Lecture_10;

import Base.BasketPage;
import Base.LoginPage;
import driver.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*Написать тесты на добавления/удаление товаров в корзину
(invocationCount) */

public class Task_10_2 extends BaseTest {
    LoginPage log;
    BasketPage basket;

    @BeforeTest
    public void preconditions() {
        log = new LoginPage(driver);
        basket = new BasketPage(driver);
        log.open().Authorization("standard_user", "secret_sauce");
    }

    @Test(invocationCount = 6)
    public void addToCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[starts-with(@name, 'add')]")).click();
    }

    @Test(invocationCount = 6, dependsOnMethods = "addToCart")
    public void removeFromCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[starts-with(@name, 'remove')]")).click();
    }
    @Test (dependsOnMethods = "removeFromCart")
    public void check () {
        int count = (driver.findElements(By.xpath("//*[starts-with(@name, 'add')]")).size());
        Assert.assertEquals(count, 6);
    }
}
