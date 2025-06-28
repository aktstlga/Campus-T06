package StepDefinitions;

import Pages.TopNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class _21_AssignmentsSubmit {
    TopNav TN = new TopNav();
    Faker faker = new Faker();
    public static String lastTypedMessage;

    @And("The user inputs a random message, table, and attached file into the rich text editor")
    public void randomMessage() throws AWTException, InterruptedException {
        GWD.getDriver().switchTo().frame(TN.richTextIframe);
        String randomMessage = faker.lorem().paragraph(2);
        TN.richTextEditorBody.clear();
        TN.richTextEditorBody.sendKeys(randomMessage);
        lastTypedMessage = randomMessage;
        System.out.println("Rastgele mesaj yazıldı: " + randomMessage);

        GWD.getDriver().switchTo().defaultContent();
        System.out.println("Rich text iframe'inden çıkıldı.");

        TN.waitUntilClickable(TN.tableMenuBarButton);
        TN.jsClick(TN.tableMenuBarButton);
        System.out.println("Menü çubuğundaki 'Table' düğmesi tıklandı.");

        TN.waitUntilClickable(TN.tableMenuOption);
        TN.jsClick(TN.tableMenuOption);
        System.out.println("Tablo menüsünden 'Table' seçeneği tıklandı.");

        TN.waitUntilClickable(TN.twoByTwoTableOption);
        TN.jsClick(TN.twoByTwoTableOption);
        System.out.println("2x2 tablo boyutu seçildi.");

        GWD.getDriver().switchTo().frame(TN.richTextIframe);
        TN.richTextEditorBody.sendKeys("\n\nTablo eklendi.");
        System.out.println("Rich text iframe'ine geri dönüldü ve ek metin yazıldı.");

        GWD.getDriver().switchTo().defaultContent();
        System.out.println("İkinci kez rich text iframe'inden ana içeriğe geçildi.");

        TN.myClick(TN.assignmentsAttachmentButton);
        System.out.println("Ek düğmesine tıklandı.");

        TN.waitUntilClickable(TN.fromLocalOption);
        TN.jsClick(TN.fromLocalOption);
        System.out.println("'From Local' seçeneğine tıklandı.");

        String filePath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "profile.png";
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("Dosya başarıyla yüklendi (Robot): " + filePath);
    }

    @And("The user saves the draft and then submits the assignment with a wait in between")
    public void saveAndSubmitWithWait() {

        TN.jsClick(TN.saveAsDraftButton);
        System.out.println("Save as Draft button clicked.");


        TN.jsClick(TN.submitButtonPanel);
        System.out.println("Submit button clicked.");
    }

    @Then("The user confirms the submission by clicking {string}")
    public void userConfirmsSubmission(String buttonText) {
        TN.waitUntilVisible(TN.confirmYesButton);
        TN.jsClick(TN.confirmYesButton);
        System.out.println("Clicked on the '" + buttonText + "' confirmation button.");

    }

    @And("The user should see a success message confirming the submission")
    public void verifySuccessMessage() {
        boolean found = TN.waitForToastMessage("Successfully submitted to review", 5);
        Assert.assertTrue(found, "Success toast message did not appear in time.");
    }
}