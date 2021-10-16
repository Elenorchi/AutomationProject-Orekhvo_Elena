package Lecture_10_11;

/* Написать тесты на Логин страницу - 1 позитивный и 5 негативных с
использованием @DataProvider  */

import Base.SauseDemo.LoginPage;
import driver.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task_10_1 extends BaseTest {
    LoginPage log;

    @BeforeClass
    public void precondition() {
        log = new LoginPage(driver);
    }

    @DataProvider(name = "Login data")
    public Object[][] dataForLoginPage() {
        return new Object[][]{
                {"standard_user", "secret_sauce", null},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "513651", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Login data")
    public void login(String user, String pass, String expectedError) {
        log.open().Authorization(user, pass);
        if (expectedError != null) {
            Assert.assertEquals(log.textOfError(), expectedError);
        } else {
            Assert.assertTrue(log.productsDisplayed());
        }
    }
}
