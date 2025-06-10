package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ParentPages extends GWD {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void myClick(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void mySendKeys(WebElement element, String text) {
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void hoverOver(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        new Actions(GWD.getDriver()).moveToElement(element).perform();
    }

    public void jsClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void WaitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public int randomGenerator(int range) {
        return (int) (Math.random() * range);
    }

    public void Wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void verifyContainsText(WebElement element, String text) {
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void verifyEqualsText(WebElement element, String text) {
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().equals(text.toLowerCase()));
    }

    public void verifyUrlContains(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }

    public void mySelect(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(text.trim());
    }
}