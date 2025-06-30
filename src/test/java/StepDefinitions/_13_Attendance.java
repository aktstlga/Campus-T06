package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _13_Attendance {
    DialogContent dc = new DialogContent();

    @Given("The user clicks the Attendance button from the top navigation")
    public void clickAttendanceButton() {
        dc.myClick(dc.attendanceButton);
    }

    @When("The user clicks on the Attendance Excuses button")
    public void clickAttendanceExcuses() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(dc.attendanceExcuses));
        wait.until(ExpectedConditions.elementToBeClickable(dc.attendanceExcuses));

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.attendanceExcuses);
    }

    @Then("The user should able to reports into excuses")
    public void verifyAttachFilesVisible() {
    }
}
