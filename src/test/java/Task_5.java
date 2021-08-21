import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task_5 {
    public static WebDriver driver = new ChromeDriver();

    @DataProvider
    public Object[][] dataprovider() {
        return new Object[][]{
                {
                        new HashMap<String, Integer>() {{
                            put("calc_roomwidth", 11);
                            put("calc_roomheight", 11);
                            put("calc_lamwidth", 1200);
                            put("calc_lamheight", 200);
                            put("calc_inpack", 10);
                            put("calc_price", 350);
                            put("calc_bias", 250);
                            put("calc_walldist", 30);
                        }}
                }
        };
    }

    public void enter(Object key, Object value) {
        WebElement webel = driver.findElement(By.name(String.valueOf(key)));
        webel.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), value.toString());
    }

    @Test(dataProvider = "dataprovider")
    public void Test1(HashMap map) throws InterruptedException {
        {
            driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
            Thread.sleep(5000);
            map.forEach((key, value) -> {
                enter(key, value);
            });
            WebElement select = driver.findElement(By.name("calc_direct"));
            WebElement option = driver.findElement(By.xpath("//*[@value = 'toh']"));
            select.click();
            option.click();
            driver.findElement(By.xpath("//*[@value = 'Рассчитать']")).click();
            List<String> list = new ArrayList<>();
            driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-12 whiteback']//span[@id]")).forEach(data -> list.add(data.getText()));
            List<String> list2 = Arrays.asList("108.74 м2.", "462 шт.", "47 шт.", "39480 руб.", "8 шт.", "11 шт.");
            Assert.assertTrue(Arrays.equals(new List[]{list}, new List[]{list2}));
        }
    }

    @Test
    public void Test2() {
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Hello World", Keys.ENTER);
        Actions actions = new Actions(driver);
        WebElement el = driver.findElement(By.xpath("(//h3[@class='LC20lb DKV0Md'])[10]"));
        actions.moveToElement(el).perform();
        el.click();
        Assert.assertTrue(driver.findElement(By.xpath("//div [@class ='container-fluid']")).isDisplayed());
    }

    @Test
    public void Test3() {
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("//", Keys.ENTER);
        String result = (driver.findElement(By.xpath("//div[@class ='card-section']")).getText());
        System.out.println(result);

        String OurCheck = "По запросу // ничего не найдено. \n" +
                "Рекомендации:\n" +
                "Убедитесь, что все слова написаны без ошибок.\n" +
                "Попробуйте использовать другие ключевые слова.\n" +
                "Попробуйте использовать более популярные ключевые слова.";

        Assert.assertTrue(result.equals(OurCheck));
    }
    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}
