package core;

import automationpractice.Bot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicActionsIntegration {

    protected WebDriver bot;
    protected static final String URL = "http://automationpractice.com/";

    @BeforeClass
    public void openBrowser() {
        bot = new Bot().getBot();
        bot.get(URL);
    }

//    protected static void logStep(String step) {
//        Logger.step(step);
//    }

    @AfterClass
    public void close() {
        bot.quit();
    }
}
