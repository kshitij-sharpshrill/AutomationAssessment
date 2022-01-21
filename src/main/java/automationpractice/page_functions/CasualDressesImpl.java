package automationpractice.page_functions;

import automationpractice.page_ors.ShopandCart.ShopCartPage;
import automationpractice.utils.BasicActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CasualDressesImpl extends BasicActions {

    public CasualDressesImpl(WebDriver bot) {
        super(bot);
    }
    @Step("Selecting the product")
    public ProductPageImpl selectProduct(){
        sleep(3);
        click(ShopCartPage.Product_div);
        return new ProductPageImpl(bot);
    }
}
