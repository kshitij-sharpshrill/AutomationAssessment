package automationpractice.page_functions;


import automationpractice.page_ors.contact.ContactPage;
import automationpractice.utils.BasicActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ContactPageImpl extends BasicActions {

    public ContactPageImpl(WebDriver bot) {
        super(bot);
    }

    SoftAssert softAssert = new SoftAssert();

//1- Open Applicaton
//2- Verify correct site is opened
//3- Click “Contact Us”
//4- Select “Customer Service” from  Subject heading
//5- Enter valid email address and add some message and click send
//6- Verify Success Message

    //Filling the form

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
        softAssert.assertTrue(checkElement(ContactPage.Success_Message), "Success Message is visible");

    }

    @Step("Verifying Invalid Error Message")
    public void verifyErrorMessage() {
        sleep(2);
        softAssert.assertTrue(checkElement(ContactPage.Error_Message), "Error Message is visible");

    }
}
