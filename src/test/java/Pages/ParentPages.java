package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

        wait.until(ExpectedConditions.elementToBeClickable(chosenElement));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", chosenElement);
    }

    public void topNavClick(WebElement firstElement, WebElement secondElement, WebElement thirdElement, String text) {
        jsClick(firstElement);
        hoverOver(secondElement);
        jsClick(thirdElement);
        verifyUrlContains(text);
    }

    public void topNavClick(WebElement firstElement, WebElement secondElement, String text) {
        jsClick(firstElement);
        jsClick(secondElement);
        verifyUrlContains(text);
    }

    public void clickEsc(WebElement element, WebElement secondElement) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        jsClick(element);
        wait.until(ExpectedConditions.visibilityOfAllElements(secondElement));
        Assert.assertTrue(secondElement.isDisplayed());
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public boolean waitForToastMessage(String message, int timeoutSeconds) {
        boolean found = false;
        int attempts = timeoutSeconds * 5;
        for (int i = 0; i < attempts; i++) {
            String bodyText = (String) ((JavascriptExecutor) GWD.getDriver())
                    .executeScript("return document.body.innerText");
            if (bodyText.contains(message)) {
                found = true;
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return found;
    }

    public void scrollToBottomAndWaitForElements(List<WebElement> elements, int timeoutSeconds) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void scrollToEachElement(List<WebElement> elements) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        for (WebElement element : elements) {
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}