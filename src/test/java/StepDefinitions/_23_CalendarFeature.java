package StepDefinitions;

import Pages.TopNav;
import Pages.DialogContent;
import io.cucumber.java.en.*;

public class _23_CalendarFeature {

    TopNav topNav = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("The user clicks the Calendar button from the top navigation")
    public void theUserClicksTheCalendarButtonFromTheTopNavigation() {
        topNav.myClick(topNav.calendarButton);
    }

    @When("The user clicks on the SideCalendar button and the Previous, Today, and Next icons")
    public void theUserClicksOnTheSideCalendarButtonAndThePreviousTodayAndNextIcons() {
        dc.myClick(dc.sideCalendarButton);
        dc.myClick(dc.previousIcon);
        dc.myClick(dc.todayIcon);
        dc.myClick(dc.nextIcon);
    }

    @Then("The calendar view should update accordingly")
    public void calendarViewShouldUpdateAccordingly() {
        dc.verifyElementContainsText(dc.lessonBox, "Teacher_1");
    }
}
