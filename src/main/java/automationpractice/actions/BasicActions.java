package automationpractice.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicActions {

    protected final WebDriver bot;
    protected final WebDriverWait waiter;

    protected BasicActions(WebDriver bot) {
        this.bot = bot;
        this.waiter = new WebDriverWait(bot, 10);
    }

    protected boolean waitForVisibility(By element) {
        boolean isVisible = true;
        try {
            waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException te) {
            isVisible = false;
        }
        return isVisible;
    }

    protected void click(By element) {
        bot.findElement(element).click();
    }

    protected void enterText(By element, String text) {
        bot.findElement(element).sendKeys(text);
    }

    protected String pageTitle() {return bot.getTitle(); }

    protected boolean checkElement(By element) {
        if(element!= null){
            return true;
        }
        else{
            return false;
        }
    }

    protected void quitBrowser(){
        bot.quit();
    }

    public static void sleep(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
