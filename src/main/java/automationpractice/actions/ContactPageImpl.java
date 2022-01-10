package automationpractice.actions;


import automationpractice.pages.contact.ContactPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ContactPageImpl extends BasicActions {

    public ContactPageImpl(WebDriver bot) {
        super(bot);
    }

//1- Open Applicaton
//2- Verify correct site is opened
//3- Click “Contact Us”
//4- Select “Customer Service” from  Subject heading
//5- Enter valid email address and add some message and click send
//6- Verify Success Message

    @Step("Verifying that correct site is opened")
    public void verifySite() {
        waitForVisibility(ContactPage.ContactUs_button);
        Assert.assertEquals(pageTitle(), "My Store");
    }

    @Step("Clicking on Contact Us button")
    public void clickContactUs() {
        click(ContactPage.ContactUs_button);
    }

    @Step("Selecting Customer Service")
    public void customerService() {
        sleep(3);
        click(ContactPage.SelectService);
    }

    @Step("Entering email address")
    public void enterEmailID(String email) {
        enterText(ContactPage.EmailId_text, email);
    }

    @Step("Entering some message")
    public void enterMessage(String message) {
        enterText(ContactPage.Message_area, message);
    }

    @Step("Clicking on Submit button")
    public void submit() {
        click(ContactPage.Submit_button);
    }

    @Step("Verifying Success Message")
    public void verifySuccessMessage() {
        sleep(2);
        Assert.assertTrue(checkElement(ContactPage.Success_Message));

    }

    @Step("Verifying Invalid Error Message")
    public void verifyErrorMessage() {
        sleep(2);
        Assert.assertTrue(checkElement(ContactPage.Error_Message));

    }
}
