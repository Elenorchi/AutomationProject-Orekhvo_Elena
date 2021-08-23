import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Task_6 {
    public static WebDriver driver = new ChromeDriver();

    @Test
    public void test1() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        WebElement select = driver.findElement(By.className("product_sort_container"));
        WebElement option = driver.findElement(By.cssSelector("[value=lohi]"));
        select.click();
        option.click();
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).click();
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
        driver.findElement(By.tagName("span")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@id='item_4_title_link']/*[1]")).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='inventory_item_price']")).getText(), "$29.99");
        //driver.findElement(By.linkText("Twitter")).click(); // вариант исп-я LinkText
        //driver.findElement(By.partialLinkText("Face")).click(); // вариант исп-я partialLinkText
    }

    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}