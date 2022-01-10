package automationpractice.actions;

import automationpractice.pages.ShopandCart.ShopCartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ShopCartPageImpl extends BasicActions {

    public ShopCartPageImpl(WebDriver bot) { super(bot);}

//1- Open Applicaton
//2- Click on Dresses | Casual Dresses
//3- Select one Item from Result and add to cart
//4- Open the cart and verify the same item added in cart and price is correct

    @Step("Clicking on Dresses")
    public void clickDresses(){
        sleep(8);
        click(ShopCartPage.Dresses);
        sleep(6);
    }

    @Step("Clicking on Casual Dresses")
    public void clickCasualDresses(){
        click(ShopCartPage.CasualDresses);
    }

    @Step("Selecting the product")
    public void selectProduct(){
        sleep(3);
        click(ShopCartPage.Product_div);
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
    public void openCart(){
        sleep(2);
        click(ShopCartPage.Cart_btn);
    }

    @Step("Verifying the Product Name")
    public void nameCheck(){
        System.out.println("Name checking started");
        Assert.assertTrue(dataMatcher(ShopCartPage.ProdTextName, ShopCartPage.CartProductName));
        System.out.println("Name checking complete");
    }

    @Step("Verifying the Product Price")
    public void priceCheck(){
        System.out.println("Price checking started");
        Assert.assertTrue(dataMatcher(ShopCartPage.PriceTextName, ShopCartPage.CartProductPrice));
        System.out.println("Price checking completed");
    }
}
