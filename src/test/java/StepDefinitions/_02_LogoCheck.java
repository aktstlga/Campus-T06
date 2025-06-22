package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Set;

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

    @And("The user should be directed to Techno Study mainpage")
    public void theUserShouldBeRedirectedToTechnoStudyMainpage() {
        String originalWindow = GWD.getDriver().getWindowHandle();
        Set<String> allWindows = GWD.getDriver().getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                GWD.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        DialogContent.quitDriver();
    }
}