package automationpractice.page_functions;

import automationpractice.page_ors.ShopandCart.ShopCartPage;
import automationpractice.utils.BasicActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ProductPageImpl extends BasicActions {

    public ProductPageImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Adding the product to Cart")
    public void addToCart(){
        sleep(3);
        //Saving the product name for verifying with the cart
        ShopCartPage.ProdTextName= textRetriever(ShopCartPage.ProductName);

        //Saving the product price for verifying with the cart
        ShopCartPage.PriceTextName= textRetriever(ShopCartPage.ProductPrice);

        //Adding the product to cart
        click(ShopCartPage.AddToCart);
    }

    @Step("Closing the popup")
    public void closePopup(){
        sleep(2);
        clickPopupElement(ShopCartPage.PopupCross);
    }

    @Step("Opening the Cart")
    public CartPageImpl openCart(){
        sleep(2);
        click(ShopCartPage.Cart_btn);

        return new CartPageImpl(bot);
    }
}
