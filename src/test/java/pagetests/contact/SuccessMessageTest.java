package pagetests.contact;

import automationpractice.page_functions.ContactPageImpl;
import automationpractice.page_functions.HomePageImpl;
import core.BasicActionsIntegration;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Test
@Epic("EPIC 1")
public class SuccessMessageTest extends BasicActionsIntegration {

    HomePageImpl home;


    @Test
    @Description("Creating ContactPageImpl objects before class")
    public void initImpl() {
        home = new HomePageImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Feature 1")
    @Story("STORY 1")
    @Owner("Kshitij Kumar")
    public void test1_to_open_the_correct_site_and_get_success_message(){
        stepLog("Verify correct site is opened");
        home.verifySite();

        stepLog("Click “Contact Us”");
        ContactPageImpl contact = home.clickContactUs();


        stepLog("Select “Customer Service” from  Subject heading");
        contact.customerService();

        stepLog("Enter valid email address, add some message and click send");
        contact.enterEmailID("abc@gmail.com");
        contact.enterMessage("Sending Random Message Text");
        contact.submit();

        stepLog("Verify Success Message");
        contact.verifySuccessMessage();
        closeBrowser();
    }

    @Test(dependsOnMethods = "initImpl")
    @Description(" Verify the error message on sending invalid email id")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Feature 1")
    @Story("STORY 2")
    @Owner("Kshitij Kumar")
    public void test2_to_open_the_correct_site_and_get_error_message(){
        openBrowser();
        stepLog("Verify correct site is opened");
        home.verifySite();

        stepLog("Click “Contact Us”");
        ContactPageImpl contact = home.clickContactUs();

        stepLog("Select “Customer Service” from  Subject heading");
        contact.customerService();

        stepLog("Enter invalid email address, add some message and click send");
        contact.enterEmailID("abcgmail.com");
        contact.enterMessage("Sending Random Message Text");
        contact.submit();

        stepLog("Verify Error Message");
        contact.verifyErrorMessage();
    }
}