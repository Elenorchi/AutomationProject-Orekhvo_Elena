package driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static driver.DriverCreation.getDriver;
import static driver.DriverCreation.quitDriver;

public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = getDriver();
    }

    @AfterTest
    public void closeDriver() {
        quitDriver();
    }
}