import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch {
    @Test
    public void Test1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Hello World", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("(//h3)[1]")).getText(),"Hello, world! Карта для тех, кто летает | МТБанк") ;
        driver.quit();
    }
}
