package StepDefinitions;

import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class _14_ProfilePicture {
    TopNav TN = new TopNav();
    DialogContent DC = new DialogContent();

    @Given("The user navigates to profile settings")
    public void navigateToProfileSettings(){
        TN.myClick(TN.profileSettings);
        TN.myClick(TN.settings);
    }

    @And("The user uploads a new profile picture")
    public void uploadNewProfilePicture(){
        String filePath = System.getProperty("user.home") + "\\Desktop\\profile.png";
        By uploadPictureBy = By.cssSelector("input[type='file'][accept='.jpg,.jpeg,.png,.avif']");
        TN.myClick(TN.uploadPicture);
        TN.waitForPresence(uploadPictureBy);
        TN.forceVisible(TN.uploadPictureProfile);
        TN.uploadPictureProfile.sendKeys(filePath);
        TN.myClick(TN.uploadButton);
    }

    @Then("The user clicks the save button")
    public void saveAndSuccesfully() {
        TN.waitUntilVisible(TN.saveButton);
        TN.scrollToElement(TN.saveButton);
        TN.clickWithJS(TN.saveButton);
    }
}