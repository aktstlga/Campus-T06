package StepDefinitions;
import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _25_CalendarVideo {
    DialogContent dc = new DialogContent();
    TopNav topNav = new TopNav();

    @Given("The user clicks the Calendar button")
    public void theUserClicksTheCalendarButton() {
        topNav.myClick(topNav.calendarButton);
    }

    @When("The user clicks on the lesson icon from the course name")
    public void theUserClicksOnTheLessonIconFromTheCourseName() {
        dc.myClick(dc.lessonBox);
    }

    @When("The user clicks on the recording button")
    public void theUserClicksOnTheRecordingButton() {
        dc.myClick(dc.recordingButton);
    }

    @Then("The video should be visible accordingly")
    public void theVideoShouldBeVisibleAccordingly() {
        Assert.assertTrue(dc.recordingButton.isDisplayed());

    }
}

