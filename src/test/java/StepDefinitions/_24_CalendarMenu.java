package StepDefinitions;

import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _24_CalendarMenu {
    TopNav topNav = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("The user clicks the Calendar button from the top navigation on the home page")
    public void theUserClicksTheCalendarButtonFromTheTopNavigationOnTheHomePage() {
        topNav.myClick(topNav.calendarButton);
    }

    @When("The user clicks on the lesson icon")
    public void theUserClicksOnTheLessonIcon() {
        dc.myClick(dc.lessonBox);
    }

    @Then("The lesson details should be visible")
    public void theLessonDetailsShouldBeVisible() {
        Assert.assertTrue(dc.lessonBox.isDisplayed());
    }
}
