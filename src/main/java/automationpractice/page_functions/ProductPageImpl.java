package automationpractice.page_functions;

import automationpractice.page_ors.shopandCart.ProductPage;
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
        ProductPage.ProdTextName= textRetriever(ProductPage.ProductName);

        //Saving the product price for verifying with the cart
        ProductPage.PriceTextName= textRetriever(ProductPage.ProductPrice);

        //Adding the product to cart
        click(ProductPage.AddToCart);
    }

    @Step("Closing the popup")
    public void closePopup(){
        sleep(2);
        clickPopupElement(ProductPage.PopupCross);
    }

    @Step("Opening the Cart")
    public CartPageImpl openCart(){
        sleep(2);
        click(ProductPage.Cart_btn);

        return new CartPageImpl(bot);
    }
}
