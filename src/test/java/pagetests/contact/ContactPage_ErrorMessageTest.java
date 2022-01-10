package pagetests.contact;

import automationpractice.actions.ContactPageImpl;
import core.BasicActionsIntegration;
import core.Logger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

    @Test
    @Epic("EPIC 2")
    public class ContactPage_ErrorMessageTest extends BasicActionsIntegration {

        ContactPageImpl contacterror;
        Logger L = new Logger();

        @Test
        @Description("Creating impl objects before class")
        public void initImpl() {
            contacterror = new ContactPageImpl(bot);
        }

        @Test(dependsOnMethods = "initImpl")
        @Description(" Verify the error message on sending invalid email id")
        @Owner("Kshitij Kumar")
        public void test_to_open_the_correct_site_and_get_error_message(){
            L.step("Verify correct site is opened");
            contacterror.verifySite();

            L.step("Click “Contact Us”");
            contacterror.clickContactUs();

            L.step("Select “Customer Service” from  Subject heading");
            contacterror.customerService();

            L.step("Enter invalid email address, add some message and click send");
            contacterror.enterEmailID("abcgmail.com");
            contacterror.enterMessage("Sending Random Message Text");
            contacterror.submit();

            L.step("Verify Error Message");
            contacterror.verifyErrorMessage();
        }
}
