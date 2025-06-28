package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopNav extends ParentPages {
    public TopNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "div > div:nth-child(2) > button > span.mdc-button__label")
    public WebElement profileSettings;

    @FindBy(xpath = "//button[.//span[text()='Settings']]")
    public WebElement settings;

    @FindBy(xpath = "//img[contains(@class, 'profile-image') and contains(@class, 'avatar')]")
    public WebElement uploadPicture;

    @FindBy(css = "input[type='file'][accept='.jpg,.jpeg,.png,.avif']")
    public WebElement uploadPictureProfile;

    @FindBy(xpath = "//span[@class='mdc-button__label' and normalize-space()='Upload']")
    public WebElement uploadButton;

    @FindBy(xpath = "//button[.//span[normalize-space()='Save']]")
    public WebElement saveButton;

    @FindBy(css = "mat-select[formcontrolname='theme']")
    public WebElement themeDropdown;

    @FindBy(css = "mat-option span.mdc-list-item__primary-text")
    public List<WebElement> themeOptions;

    @FindBy(xpath = "//span[contains(text(),'Calendar') and contains(@class,'mat-badge')]")
    public WebElement calendarButton;

    @FindBy(xpath = "//ms-layout-menu-button[@page='ASSIGNMENT']//button")
    public WebElement assignmentsButton;

    @FindBy(xpath = "//ms-icon-button[@icon='comments-alt']/button")
    public List<WebElement> discussionButtons;

    @FindBy(css = "div.mat-mdc-dialog-surface.mdc-dialog__surface")
    public WebElement discussionDialogSurface;

    @FindBy(css = "span.title.dialog-title")
    public WebElement discussionPanelDynamicTitle;

    @FindBy(css = "mat-selection-list.mat-mdc-selection-list mat-list-option")
    public List<WebElement> chatListOptions;

    @FindBy(css = "ms-standard-button[icon='messages'] button")
    public WebElement chatsButton;

    @FindBy(css = "textarea[formcontrolname='commentText']")
    public WebElement messageInput;

    @FindBy(xpath = "//ms-icon-button[@icon='paper-plane']/button")
    public WebElement sendMessageButton;

    @FindBy(css = "button[aria-label='Close dialog']")
    public WebElement closeDialogButton;

    @FindBy(xpath = "(//ms-icon-button[@icon='paperclip']/button)[2]")
    public WebElement attachmentButton;

    @FindBy(xpath = "//ms-icon-button[@icon='info']/button")
    public List<WebElement> infoIconButtons;

    @FindBy(xpath = "//*[@id='container-3']/my-assignments-form-page/my-assignments-form/div/div/div/div/div[1]/div[1]")
    public WebElement infoPanelParentDiv;

    @FindBy(xpath = "//div[contains(@style, 'cursor: pointer') and contains(@fxlayoutalign, 'space-between center')]")
    public List<WebElement> spacePanel;

    @FindBy(xpath = "//mat-toolbar-row[contains(@class,'mat-toolbar-row')]//span[contains(@class,'dialog-title')]")
    public WebElement submissionPanel;

    @FindBy(xpath = "//ms-icon-button[@icon='file-import']/button")
    public List<WebElement> submitButton;

    @FindBy(xpath = "//ms-layout-menu-button[@icon='users-class']/button")
    public WebElement attendanceButton;

    @FindBy(xpath = "//span[contains(text(),'Grading')]")
    public WebElement gradingButton;

    @FindBy(xpath = "(//span[contains(text(),'Courses')])[1]")
    public WebElement coursesButton;

    @FindBy(xpath = "//user-announcement-bell/button")
    public WebElement notificationButton;

    @FindBy(css = "[fxlayoutalign='space-between center']")
    public WebElement dialog;

    @FindBy(xpath = "//user-message-bell/button")
    public WebElement messeagesInfo;

    @FindBy(xpath = "//user-message-list-dialog//ms-dialog//simple-dialog-title")
    public WebElement dialogMesseage;

    @FindBy(xpath = "//span[text()='My Certificates']")
    public WebElement myCertificates;

    @FindBy(xpath = "//span[text()='My Files']")
    public WebElement myFiles;

    public WebElement topNavElements(String element) {
        switch (element) {
            case "gradingButton":
                return this.gradingButton;
            case "calendarButton":
                return this.calendarButton;
            case "coursesButton":
                return this.coursesButton;
            case "attendanceButton":
                return this.attendanceButton;
            case "assignmentsButton":
                return this.assignmentsButton;
        }
        return null;
    }

    @FindBy(css = "iframe.tox-edit-area__iframe")
    public WebElement richTextIframe;

    @FindBy(css = "body.mce-content-body")
    public WebElement richTextEditorBody;

    @FindBy(xpath = "//ms-button[@icon='save']/button")
    public WebElement saveAsDraftButton;

    @FindBy(xpath = "//ms-confirm-button[@icon='file-import']/button")
    public WebElement submitButtonPanel;

    @FindBy(xpath = "//app-simple-dialog//button[.//span[normalize-space(text())='Yes']]")
    public WebElement confirmYesButton;

    @FindBy(xpath = "//div[@role='menubar']//button[.//span[text()='Table']]")
    public WebElement tableMenuBarButton;

    @FindBy(xpath = "//div[@role='menu']//div[contains(@class,'tox-collection__item-label') and text()='Table']")
    public WebElement tableMenuOption;

    @FindBy(css = "div.tox-insert-table-picker div[role='button'][aria-label='2 columns, 2 rows']")
    public WebElement twoByTwoTableOption;

    @FindBy(xpath = "//button[contains(@class, 'mat-mdc-menu-item') and .//span[contains(text(), 'From Local')]]")
    public WebElement fromLocalOption;

    @FindBy(xpath = "//button[.//span[text()='Attach Files...']]")
    public WebElement assignmentsAttachmentButton;
}