package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {
    By addProduct = By.id("add-to-cart-sauce-labs-bike-light");
    By basket = By.className("shopping_cart_link");
    By removeButton = By.id("remove-sauce-labs-bike-light");
    By continueBtn = By.id("continue-shopping");

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
}