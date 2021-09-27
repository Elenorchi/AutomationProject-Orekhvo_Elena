package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends BasePage {
    By addProduct = By.id("add-to-cart-sauce-labs-bike-light");
    By basket = By.className("shopping_cart_link");
    By removeButton = By.id("remove-sauce-labs-bike-light");
    By continueBtn = By.id("continue-shopping");
    By products = By.className("inventory_item_name");
    By price = By.className("inventory_item_price");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage addToBasket() {
        click(addProduct);
        return this;
    }

    public BasketPage openBasket() {
        click(basket);
        return this;
    }

    public BasketPage removeProduct() {
        click(removeButton);
        return this;
    }

    public boolean removeBtnDisplayed() {
        return display(removeButton);
    }

    public BasketPage continueShopping() {
        click(continueBtn);
        return this;
    }
    public boolean addingButtonDisplayed() {
        return display(addProduct);
    }

    public enum sort {
        AtoZ,
        ZtoA,
        lowToHigh,
        highToLow
    }

    public void sortingProductsFromAtoZ() {
        List<String> sortedList = (driver.findElements(products).stream().map(el -> el.getText()).sorted().collect(Collectors.toList()));
        List<String> normalList = (driver.findElements(products).stream().map(el -> el.getText()).collect(Collectors.toList()));
        Assert.assertEquals(sortedList, normalList);
    }
    public void sortingProductsFromZtoA() {
        List<String> sortedList = (driver.findElements(products).stream().map(el -> el.getText()).sorted().collect(Collectors.toList()));
        List<String> normalList = (driver.findElements(products).stream().map(el -> el.getText()).collect(Collectors.toList()));
        Collections.reverse(sortedList);
        Assert.assertEquals(sortedList, normalList);
    }
    public void sortingByPriceToHigh() {
        List<Double> sortedList = (driver.findElements(price).stream().map(el -> el.getText())
                .map(el -> el.replace("$", "")
                .replace(",", "."))
                .map(Double ::parseDouble).sorted()
                .collect(Collectors.toList()));
        List<Double> normalList = (driver.findElements(price).stream().map(el -> el.getText())
                .map(el -> el.replace("$",""))
                .map(el -> el.replace(",","."))
                .map(Double ::parseDouble)
                .collect(Collectors.toList()));
        Assert.assertEquals(sortedList, normalList);
    }
    public void sortingByPriceToLow() {
        List<Double> sortedList = (driver.findElements(price).stream().map(el -> el.getText())
                .map(el -> el.replace("$", "")
                        .replace(",", "."))
                .map(Double ::parseDouble).sorted()
                .collect(Collectors.toList()));
        List<Double> normalList = (driver.findElements(price).stream().map(el -> el.getText())
                .map(el -> el.replace("$",""))
                .map(el -> el.replace(",","."))
                .map(Double ::parseDouble)
                .collect(Collectors.toList()));
        Collections.reverse(sortedList);
        Assert.assertEquals(sortedList, normalList);
    }

    public void sorting(sort sort) {
        switch (sort) {
            case AtoZ:
                WebElement select1 = driver.findElement(By.className("product_sort_container"));
                WebElement option1 = driver.findElement(By.cssSelector("[value=az]"));
                select1.click();
                option1.click();
                sortingProductsFromAtoZ();
                break;
            case ZtoA:
                WebElement select2 = driver.findElement(By.className("product_sort_container"));
                WebElement option2 = driver.findElement(By.cssSelector("[value=za]"));
                select2.click();
                option2.click();
                sortingProductsFromZtoA ();
                break;
            case highToLow:
                WebElement select3 = driver.findElement(By.className("product_sort_container"));
                WebElement option3 = driver.findElement(By.cssSelector("[value=hilo]"));
                select3.click();
                option3.click();
                sortingByPriceToLow() ;
                break;
            case lowToHigh:
                WebElement select4 = driver.findElement(By.className("product_sort_container"));
                WebElement option4 = driver.findElement(By.cssSelector("[value=lohi]"));
                select4.click();
                option4.click();
                sortingByPriceToHigh();
                break;
        }
    }
}

    public boolean addingButtonDisplayed() {
        return display(addProduct);
    }
}
