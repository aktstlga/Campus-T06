package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends ParentPages {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[formcontrolname='username']")
    public WebElement username;

    @FindBy(css = "[formcontrolname='password']")
    public WebElement password;

    @FindBy(css = "span[class='mdc-button__label']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='Invalid username or password']")
    public WebElement invalidNotification;

    @FindBy(css = "span[class='username mr-12']")
    public WebElement studentCheck;

    @FindBy(xpath = "(//img)[1]")
    public WebElement logoButton;

    @FindBy(xpath = "//span[normalize-space()='Welcome, Student_6 11A !']")
    public WebElement welcomeMesseage;

    @FindBy(css = "img[alt='TechnoStudy']")
    public WebElement technoStudyLogo;

    @FindBy(css = ".popup-title")
    public WebElement lessonTitle;

    @FindBy(xpath = "//span[contains(@class,'mdc-tab__text-label') and contains(.,'Calendar')]")
    public WebElement sideCalendarButton;

    @FindBy(xpath = "//span[@class='fc-icon fc-icon-chevron-left']")
    public WebElement previousIcon;

    @FindBy(css = "button.fc-todayCalendar-button")
    public WebElement todayIcon;

    @FindBy(css = "button.fc-nextCalendar-button")
    public WebElement nextIcon;

    @FindBy(xpath = "//td[.//span[contains(text(), 'CHEMISTRY')]]")
    public WebElement lessonBox;

    @FindBy(xpath = "//*[name()='svg' and @data-icon='video']")
    public WebElement recordingButton;

    @FindBy(xpath = "//span[contains(text(),'Grading')]")
    public WebElement gradingButton;

    @FindBy(xpath = "//*[contains(@class, 'display-but-dont-print')]")
    public WebElement printIcon;

    @FindBy(xpath = "//ms-layout-menu-button[@icon='users-class']/button")
    public WebElement attendanceButton;

    @FindBy(xpath = "//div[@id='mat-tab-group-1-label-2']")
    public WebElement attendanceExcusesTab;

    @FindBy(xpath = "//span[@class='sent' and contains(text(),'Sent')]")
    public WebElement sentStatus;

    @FindBy(xpath = "//span[contains(text(),'Attach Files')]")
    public WebElement attachFilesText;

}