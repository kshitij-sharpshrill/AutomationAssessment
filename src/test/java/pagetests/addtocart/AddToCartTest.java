package pagetests.addtocart;

import automationpractice.page_functions.*;
import core.BasicActionsIntegration;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Epic 1")
public class AddToCartTest extends BasicActionsIntegration {

    HomePageImpl home;

//1- Open Applicaton
//2- Click on Dresses | Casual Dresses
//3- Select one Item from Result and add to cart
//4- Open the cart and verify the same item added in cart and price is correct

    @Test
    @Description("Creating HomePageImpl objects before class")
    public void initImpl() { home = new HomePageImpl(bot); }

    @Test(dependsOnMethods = "initImpl")
    @Description("Add product to the cart and verify whether the right product and correct price is added")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Feature 1")
    @Story("STORY 3")
    @Owner("Kshitij Kumar")
    public void add_to_cart_and_verify_name_and_price(){

        stepLog("Verify correct site is opened");
        home.verifySite();

        stepLog("Click on Dresses");
        DressesImpl dress = home.clickDresses();

        stepLog("Click on Casual Dresses");
        CasualDressesImpl casual = dress.clickCasualDresses();

        stepLog("Select one item from result");
        ProductPageImpl product = casual.selectProduct();

        stepLog("Add the selected product to cart");
        product.addToCart();
        product.closePopup();

        stepLog("Open the cart");
        CartPageImpl cart = product.openCart();

        stepLog("Verify that same item is added in the cart and its price is correct");
        cart.nameCheck();
        cart.priceCheck();
    }
}
