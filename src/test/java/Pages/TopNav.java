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
}

