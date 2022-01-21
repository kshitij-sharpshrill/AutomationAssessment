package automationpractice.page_functions;

import automationpractice.page_ors.ShopandCart.ShopCartPage;
import automationpractice.utils.BasicActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DressesImpl extends BasicActions {

    public DressesImpl(WebDriver bot) { super(bot);}

    public CasualDressesImpl transitCasualDress(WebDriver bot){
        return new CasualDressesImpl(bot);
    }

//1- Open Applicaton
//2- Click on Dresses | Casual Dresses
//3- Select one Item from Result and add to cart
//4- Open the cart and verify the same item added in cart and price is correct


    @Step("Clicking on Casual Dresses")
    public CasualDressesImpl clickCasualDresses(){
        click(ShopCartPage.CasualDresses);
        return new CasualDressesImpl(bot);
    }
}
