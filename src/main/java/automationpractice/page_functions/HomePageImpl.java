package automationpractice.page_functions;

import automationpractice.page_ors.home.HomePage;
import automationpractice.utils.BasicActions;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePageImpl extends BasicActions {

    public HomePageImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Verifying that correct site is opened")
    public void verifySite() {
        waitForVisibility(HomePage.ContactUs_button);
        Assert.assertEquals(pageTitle(), "My Store");
    }

    @Step("Clicking on Contact Us button")
    public ContactPageImpl clickContactUs() {
        click(HomePage.ContactUs_button);

        return new ContactPageImpl(bot);
    }


    @Step("Clicking on Dresses")
    public DressesImpl clickDresses(){
        sleep(8);
        click(HomePage.Dresses);
        sleep(6);
        return new DressesImpl(bot);
    }
}
