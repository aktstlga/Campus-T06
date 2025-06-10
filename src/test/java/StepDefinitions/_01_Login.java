package StepDefinitions;

import Pages.DialogContent;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import org.testng.Assert;

public class _01_Login {
    DialogContent DC = new DialogContent();
    Faker faker = new Faker();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().get("test.mersys.io");
    }

    @When("The user writes invalid username and password")
    public void theUserWritesInvalidUsernameAndPassword() {
        DC.mySendKeys(DC.username, faker.name().username());
        DC.mySendKeys(DC.password, faker.internet().password());
    }

    @And("The user clicks on login button")
    public void theUserClicksOnLoginButton() {
        DC.myClick(DC.loginButton);
    }

    @Then("The user gets notification about invalid credentials")
    public void theUserGetsNotificationAboutInvalid() {
        DC.verifyContainsText(DC.invalidNotification, "Invalid");
    }

    @When("The user writes username and password and clicks on login button")
    public void theUserWritesUsernameAndPasswordAndClicksOnLoginButton() {
        DC.mySendKeys(DC.username, ConfigReader.getProperty("username"));
        DC.mySendKeys(DC.password, ConfigReader.getProperty("password"));
    }

    @Then("The user verifies login successfully")
    public void theUserVerifiesLoginSuccessfully() {
        DC.verifyUrlContains("user");
        DC.verifyContainsText(DC.studentCheck, "S.");
    }
}