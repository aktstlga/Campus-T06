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
}
