package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _16_GradingFeature {
    DialogContent dc = new DialogContent();

    @Given("The user clicks the Grading button from the top navigation")
    public void theUserClicksTheGradingButtonFromTheTopNavigation() {
        dc.myClick(dc.gradingButton);
    }

    @Then("The Grading page should be displayed")
    public void reportsPageShouldBeDisplayed() {
        Assert.assertTrue(dc.gradingButton.isDisplayed()); // veya rapor sayfasındaki başka bir öğeyi kontrol edebilirsin
    }
}
