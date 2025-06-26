package StepDefinitions;

import Pages.TopNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.util.List;

public class _19_AssignmentsDiscussion {
    TopNav TN = new TopNav();

    public static String lastSentMessage = "";
    public static String lastUploadedFileName = "";

    @Given("The user navigates to the Assignments page")
    public void navigateToAssignments() {
        TN.myClick(TN.assignmentsButton);
    }

    @When("The user clicks on a random discussion button")
    public void randomDiscussion() {
        TN.waitForPresence(By.xpath("//ms-icon-button[@icon='comments-alt']/button"));

        List<WebElement> buttons = TN.discussionButtons;

        if (buttons.isEmpty()) {
            System.out.println("Sayfada tartışma butonu bulunamadı. /" +
                    " No discussion button found on the page.");
            Assert.fail("Tıklanacak tartışma butonu bulunamadı. / " +
                    "No discussion button to click was found.");
            return;
        }
        TN.waitUntilVisible(buttons.get(0));

        int randomIndex = TN.randomGenerator(buttons.size());
        WebElement randomDiscussionButton = buttons.get(randomIndex);

        TN.jsClick(randomDiscussionButton);
        System.out.println("Rastgele seçilen Discussion butonu (" + (randomIndex + 1) +
                ". buton) başarıyla tıklandı. / " +
                "Randomly selected Discussion button (" + (randomIndex + 1) + " " +
                "button) clicked successfully.");
    }

    @Then("The discussion panel should be displayed")
    public void discussionPanel() {
        TN.waitUntilVisible(TN.discussionDialogSurface);
        String dialogTitleText = TN.discussionPanelDynamicTitle.getText();
        System.out.println("Açılan tartışma paneli başlığı: " + dialogTitleText + " / Opened discussion panel title: " + dialogTitleText);
        Assert.assertTrue(dialogTitleText.contains("11A-") || dialogTitleText.contains("HW"),
                "Tartışma paneli başlığı beklenen ödev metnini içermiyor. Başlık: " + dialogTitleText + " " +
                        "/ Discussion panel title does not contain the expected assignment text. Title: " + dialogTitleText);
        System.out.println("Tartışma paneli başarıyla görüntülendi ve içeriği doğrulandı. / " +
                "Discussion panel displayed and content verified successfully.");
    }

    //-------------------------------------------------
    @When("The user types message {string} into the input field")
    public void messageInput(String message) {
        TN.mySendKeys(TN.messageInput, message);
        lastSentMessage = message;
        System.out.println("Mesaj kutusuna: '" + message + "' yazıldı. / " +
                "Typed into message input: '" + message + "'");
    }

    @When("The user clicks the send button")
    public void sendButton() {
        TN.myClick(TN.sendMessageButton);
        lastUploadedFileName = "";
        System.out.println("Mesaj gönder butonuna tıklandı. / " +
                "Send message button clicked.");
    }

    @Then("The user closes the discussion dialog")
    public void discussionDialogClose() {
        TN.waitUntilClickable(TN.closeDialogButton);
        TN.jsClick(TN.closeDialogButton);
        System.out.println("Tartışma penceresi kapatıldı. / " +
                "Discussion dialog closed.");
    }

    @And("The user clicks on the Chats icon in the discussion panel")
    public void chatButton() {
        System.out.println("Chats ikonuna tıklama işlemi başlatıldı... / " +
                "Clicking on the Chats icon started...");

        try {
            TN.waitUntilVisible(TN.chatsButton);
            TN.clickWithJS(TN.chatsButton);
            TN.Wait(2);

        } catch (org.openqa.selenium.TimeoutException e) {
            System.err.println("HATA: Chats ikonuna tıklarken zaman aşımı oluştu. " +
                    "Element bulunamadı veya görünür olmadı.");
            System.err.println("Hata Detayı: " + e.getMessage());
            Assert.fail("Chats ikonuna tıklarken zaman aşımı: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("HATA: Chats ikonuna tıklarken beklenmeyen bir hata oluştu.");
            System.err.println("Hata Detayı: " + e.getMessage());
            Assert.fail("Chats ikonuna tıklarken beklenmeyen hata: " + e.getMessage());
        }
    }

    @And("The user should be able to view previously initiated discussions")
    public void previouslyInitiatedDiscussions() {
        TN.waitUntilVisible(TN.chatListOptions.get(0));
        Assert.assertFalse(TN.chatListOptions.isEmpty(), "Sohbet listesi boş veya görüntülenemedi. / " +
                "Chat list is empty or not displayed.");
        System.out.println("Daha önce başlatılan " + TN.chatListOptions.size() + " adet müzakere başarıyla görüntülendi. / "
                + TN.chatListOptions.size() + " previously initiated discussions displayed successfully.");
    }

    @And("The user uploads a file using Robot")
    public void uploadFileWithRobot() throws AWTException {
        String fileNameToUpload = "profile.png";
        TN.myClick(TN.attachmentButton);

        String filePath = "C:\\Users\\Proje\\Desktop\\" + fileNameToUpload;
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Robot ile dosya yolu: '" + filePath +
                "' yapıştırıldı ve dosya yükleme başlatıldı. / " +
                "File path pasted via Robot and file upload started.");

        lastUploadedFileName = fileNameToUpload;
        lastSentMessage = "";
    }
}
