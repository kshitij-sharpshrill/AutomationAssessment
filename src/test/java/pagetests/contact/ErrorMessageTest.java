package pagetests.contact;

import automationpractice.actions.ContactPageImpl;
import core.BasicActionsIntegration;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;


    @Epic("EPIC 1")
    public class ErrorMessageTest extends BasicActionsIntegration {

        ContactPageImpl contacterror;


        @Test
        @Description("Creating ContactPageImpl objects before class")
        public void initImpl() {
            contacterror = new ContactPageImpl(bot);
        }

        @Test(dependsOnMethods = "initImpl")
        @Description(" Verify the error message on sending invalid email id")
        @Owner("Kshitij Kumar")
        public void test_to_open_the_correct_site_and_get_error_message(){
            stepLog("Verify correct site is opened");
            contacterror.verifySite();

            stepLog("Click “Contact Us”");
            contacterror.clickContactUs();

            stepLog("Select “Customer Service” from  Subject heading");
            contacterror.customerService();

            stepLog("Enter invalid email address, add some message and click send");
            contacterror.enterEmailID("abcgmail.com");
            contacterror.enterMessage("Sending Random Message Text");
            contacterror.submit();

            stepLog("Verify Error Message");
            contacterror.verifyErrorMessage();
        }
}
