package StepDefinitions;

import Pages.HamburgerMenuPOM;
import Pages.TopNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _03_TopNav {
    TopNav topNav = new TopNav();
    HamburgerMenuPOM hamburgerMenu = new HamburgerMenuPOM();

    @Given("The user clicks on the header menu:")
    public void theUserShouldClickTheFollowingMainMenuItems(DataTable datatable) {
        List<String> links = datatable.asList(String.class);
        ArrayList<String> urlParts = new ArrayList<>();
        Collections.addAll(urlParts, "grading", "calendar", "courses", "attendance", "assignment");

        for (int i = 0; i < links.size(); i++) {
            topNav.jsClick(topNav.topNavElements(links.get(i)));
            topNav.verifyUrlContains(urlParts.get(i));
        }
    }

    @Then("The user clicks on the Hamburger menu")
    public void theUserClicksOnTheHamburgerMenu() {
        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.messaging, hamburgerMenu.sendMessage, "messages");
        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.messaging, hamburgerMenu.ınbox, "inbox");
        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.messaging, hamburgerMenu.outbox, "outbox");
        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.messaging, hamburgerMenu.trash, "trash");

        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.finance, hamburgerMenu.myFinance, "finance");

        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.attendanceButton, hamburgerMenu.attendanceExcusesButton, "attendance");

        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.videoConferenceButton, hamburgerMenu.videoMeetingsButton, "meetings" );

        hamburgerMenu.topNavClick(hamburgerMenu.hamburgerMenu, hamburgerMenu.surveyButton, hamburgerMenu.mySurveyButton,"surveys");
    }
    @And("The user clicks on Profile menu")
    public void theUserClicksOnProfileMenu() {
        topNav.clickEsc(topNav.notificationButton, topNav.dialog);
        topNav.clickEsc(topNav.messeagesInfo, topNav.dialogMesseage);

        topNav.topNavClick(topNav.profileSettings,topNav.myCertificates,"certificates");

        topNav.myClick(topNav.profileSettings);
        topNav.clickEsc(topNav.myFiles,topNav.dialog);


    }
}