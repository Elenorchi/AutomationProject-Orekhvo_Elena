import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_5 {
    @Test
    public void Test2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        driver.findElement(By.name("calc_roomwidth")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "11");
        driver.findElement(By.name("calc_roomheight")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "12");
        driver.findElement(By.name("calc_lamwidth")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "1200");
        driver.findElement(By.name("calc_lamheight")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "200");
        driver.findElement(By.name("calc_inpack")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "10");
        driver.findElement(By.name("calc_price")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "350");
        WebElement select = driver.findElement(By.name("calc_direct"));
        WebElement option = driver.findElement(By.xpath("//*[@value = 'tow']"));
        select.click();
        option.click();
        driver.findElement(By.name("calc_bias")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "250");
        driver.findElement(By.name("calc_walldist")).sendKeys (Keys.chord (Keys.CONTROL, "a", Keys.DELETE), "30");
        driver.findElement(By.xpath("//*[@value = 'Рассчитать']")).click();

    }
}

