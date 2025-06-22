package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;

public class _13_Attendance {
    DialogContent dc = new DialogContent();

    @Given("The user clicks the Attendance button from the top navigation")
    public void clickAttendanceButton() {
        dc.myClick(dc.attendanceButton);
    }

    @When("The user clicks on the Attendance Excecuses button")
    public void clickAttendanceExcuses() {
        GWD Driver;
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.attendanceExcusesTab);
    }


    @Then("The user should able to excecuses")
    public void verifySentStatusVisible() {
        dc.verifyElementContainsText(dc.sentStatus, "Sent");
    }

    @Then("The user should able to reports into excecuses")
    public void verifyAttachFilesVisible() {
        dc.verifyElementContainsText(dc.attachFilesText, "Attach Files");
    }
}
