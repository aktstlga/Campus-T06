package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class _02_LogoCheck {
    DialogContent DC = new DialogContent();

    @And("Techno Study Logo on the left corner of page should be visible")
    public void technoStudyLogoOnTheLeftCornerOfPageShouldBeVisible() {
        DC.waitUntilVisible(DC.logoButton);
    }

    @Given("The user verifies that is on Campus mainpage")
    public void theUserVerifiesThatIsOnCampusMainpage() {
        DC.verifyUrlContains("user-courses");
        DC.verifyContainsText(DC.welcomeMesseage, "Welcome");
    }

    @Then("The user clicks on the Techno Study logo")
    public void theUserClicksOnTheTechnoStudyLogo() {
        DC.myClick(DC.logoButton);
    }

    @And("The user should be redirected to Techno Study mainpage")
    public void theUserShouldBeRedirectedToTechnoStudyMainpage() {
        //Switch window sonrasında kontrol unutma
        DialogContent.quitDriver();
    }
}
