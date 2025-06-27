package StepDefinitions;

import Pages.TopNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class _20_AssingmentsButtonsControl {
    TopNav TN = new TopNav();

    @When("The user clicks the \"info\" icon button on a random assignment card")
    public void randomInfoButton() {
        TN.waitUntilAllVisible(TN.infoIconButtons);
        TN.clickRandomElementFromList(TN.infoIconButtons);
        System.out.println("Info ikonuna tıklama başarılı / Info icon button clicked successfully.");
    }

    @Then("The user should see the assignment details page")
    public void assignmentDetailsPage() {
        TN.waitUntilVisible(TN.infoPanelParentDiv);
        boolean hasContent = false;
        List<WebElement> firstLevelDivs = TN.infoPanelParentDiv.findElements(By.xpath("./div"));
        for (WebElement firstLevelDiv : firstLevelDivs) {
            List<WebElement> secondLevelDivs = firstLevelDiv.findElements(By.xpath("./div"));
            if (secondLevelDivs.size() >= 2) {
                String label = secondLevelDivs.get(0).getText().trim();
                String value = secondLevelDivs.get(1).getText().trim();
                if (!label.isEmpty() && !value.isEmpty()) {
                    System.out.println(label + "  " + value);
                    hasContent = true;
                }
            }
        }
        assertTrue(hasContent, "Assignment details page content should be displayed");
    }

    @And("The user returns to the Assignments page")
    public void theUserReturnsToAssignmentsPage() {
        TN.myClick(TN.assignmentsButton);
        System.out.println("Kullanıcı tekrar Assignments sayfasına yönlendirildi. / User is redirected back to the Assignments page.");

    }

    @When("The user clicks on an area of the assignment card excluding the icons")
    public void clickOutsideIconsOnAssignmentCard() {
        TN.waitUntilAllVisible(TN.spacePanel);
        TN.clickRandomElementFromList(TN.spacePanel);
        System.out.println("İkonlar dışına başarıyla tıklandı, ödev detay sayfasına yönlendirildi / Clicked outside icons successfully and redirected to assignment details page.");
    }

    @When("The user clicks the 'submit' icon on a random assignment card")
    public void randomAssignmentCard() {
        TN.waitUntilAllVisible(TN.submitButton);
        TN.clickRandomElementFromList(TN.submitButton);
        System.out.println("Submit ikonuna tıklama başarılı / Submit icon button clicked successfully.");

    }

    @Then("The user should see the submission dialog")
    public void submissionDialog() {
        TN.waitUntilVisible(TN.submissionPanel);
        String titleText = TN.submissionPanel.getText();
        System.out.println("Gösterilen dialog başlığı / Displayed dialog title: " + titleText);
        Assert.assertTrue(titleText.contains("Submission Attempt(s):"), "Dialog başlığı beklenilen formatta değil!");
    }
}