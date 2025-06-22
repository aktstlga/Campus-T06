package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _17_GradingPrint {
    DialogContent dc = new DialogContent();

    @Given("The user clicks the Grading button from the top navigation on home page")
    public void theUserClicksTheGradingButtonFromTheTopNavigationOnTheHomePage() {
        dc.myClick(dc.gradingButton);
    }

    @When("The user clicks the Print icon")
    public void theUserClicksThePrintIcon() {
        dc.waitUntilVisible(dc.printIcon);
        dc.myClick(dc.printIcon);
    }

    @Then("The document should be printable")
    public void theDocumentShouldBePrintable() {
        Assert.assertTrue(dc.printIcon.isDisplayed());
    }
}
