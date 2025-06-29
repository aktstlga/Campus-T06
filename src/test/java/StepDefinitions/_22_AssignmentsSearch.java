package StepDefinitions;

import Pages.TopNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class _22_AssignmentsSearch {
    TopNav TN = new TopNav();

    @When("The user selects a random predefined date range")
    public void theUserSelectsARandomPredefinedDateRange() {
        TN.waitUntilVisible(TN.datePickerToggleButton);
        TN.jsClick(TN.datePickerToggleButton);
        TN.waitUntilAllVisible(TN.quickDateButtons);
        TN.clickRandomElementFromList(TN.quickDateButtons);
    }

    @And("The user selects a random category")
    public void selectRandomCategory() {
        TN.jsClick(TN.showByDropdown);
        TN.waitUntilAllVisible(TN.showByOptions);
        TN.clickRandomElementFromList(TN.showByOptions);
    }

    @Then("The user views the assignment category header")
    public void theUserViewsTheAssignmentCategoryHeader() {
        for (WebElement header : TN.assignmentHeaders) {
            try {
                System.out.println("Başlık: " + header.getText().trim());
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element. Bu başlık atlandı.");
            }
        }
    }
}



