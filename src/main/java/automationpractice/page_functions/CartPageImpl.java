package automationpractice.page_functions;

import automationpractice.page_ors.shopandCart.CartPage;
import automationpractice.page_ors.shopandCart.ProductPage;
import automationpractice.utils.BasicActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CartPageImpl extends BasicActions {

    public CartPageImpl(WebDriver bot) {
        super(bot);
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Verifying the Product Name")
    public void nameCheck(){
        softAssert.assertTrue(dataMatcher(ProductPage.ProdTextName, CartPage.CartProductName),"Correct product is added to the cart");
    }

    @Step("Verifying the Product Price")
    public void priceCheck(){
        softAssert.assertTrue(dataMatcher(ProductPage.PriceTextName, CartPage.CartProductPrice), "Price of the product added to the cart is correct");
       }
}
