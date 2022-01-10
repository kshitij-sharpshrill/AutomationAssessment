package pagetests.contact;

import automationpractice.actions.ContactPageImpl;
import core.BasicActionsIntegration;
import core.Logger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

@Test
@Epic("EPIC 1")
public class ContactPage_SuccessMessageTest extends BasicActionsIntegration {

    ContactPageImpl contact;
    Logger L = new Logger();

    @Test
    @Description("Creating impl objects before class")
    public void initImpl() {
        contact = new ContactPageImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("")
    @Owner("Kshitij Kumar")
    public void test_to_open_the_correct_site_and_get_success_message(){
        L.step("Verify correct site is opened");
        contact.verifySite();

        L.step("Click “Contact Us”");
        contact.clickContactUs();


        L.step("Select “Customer Service” from  Subject heading");
        contact.customerService();

        L.step("Enter valid email address, add some message and click send");
        contact.enterEmailID("abc@gmail.com");
        contact.enterMessage("Sending Random Message Text");
        contact.submit();

        L.step("Verify Success Message");
        contact.verifySuccessMessage();
    }
}