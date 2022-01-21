package automationpractice.page_functions;

import automationpractice.page_ors.ShopandCart.ShopCartPage;
import automationpractice.utils.BasicActions;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;

public class CartPageImpl extends BasicActions {

    public CartPageImpl(WebDriver bot) {
        super(bot);
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Verifying the Product Name")
    public void nameCheck(){
        softAssert.assertTrue(dataMatcher(ShopCartPage.ProdTextName, ShopCartPage.CartProductName),"Correct product is added to the cart");
    }

    @Step("Verifying the Product Price")
    public void priceCheck(){
        softAssert.assertTrue(dataMatcher(ShopCartPage.PriceTextName, ShopCartPage.CartProductPrice), "Price of the product added to the cart is correct");
       }
}
