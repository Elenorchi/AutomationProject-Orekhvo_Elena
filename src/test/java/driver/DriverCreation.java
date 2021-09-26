
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    Patten Singleton
 */

public class DriverCreation {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            return driver;
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
