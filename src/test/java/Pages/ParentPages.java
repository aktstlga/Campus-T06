package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class ParentPages extends GWD {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
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

    public void waitUntilVisible(WebElement element) {
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

    public void forceVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].style.display='block'; arguments[0].style.opacity=1; arguments[0].style.visibility='visible';", element);
    }

    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void verifyTodayDateDisplayed() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
        WebElement dateElement = GWD.getDriver().findElement(By.xpath("//span[contains(text(),'" + today + "')]"));
        Assert.assertTrue(dateElement.isDisplayed());
    }

    public WebElement waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyElementContainsText(WebElement element, String text) {
        if (!element.getText().contains(text)) {
            throw new AssertionError("Text not found in element: " + text);
        }
    }

    public void waitUntilAllVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void clickRandomElementFromList(List<WebElement> elements) {
        if (elements == null || elements.isEmpty()) {
            Assert.fail("The element list is empty or null!");
        }
        WebElement chosenElement = elements.get(new Random().nextInt(elements.size()));
        scrollToElement(chosenElement);
        chosenElement.click();
    }
}



