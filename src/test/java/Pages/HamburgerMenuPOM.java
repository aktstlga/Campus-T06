package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenuPOM extends ParentPages {
    public HamburgerMenuPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='mdc-button__label'])[6]")
    public WebElement hamburgerMenu;
    @FindBy(xpath = "//*[text()='Messaging']")
    public WebElement messaging;
    @FindBy(xpath = "//*[text()='Send Message']")
    public WebElement sendMessage;
    @FindBy(xpath = "//*[text()='Inbox']")
    public WebElement ınbox;
    @FindBy(xpath = "//*[text()='Outbox']")
    public WebElement outbox;
    @FindBy(xpath = "//*[text()='Trash']")
    public WebElement trash;
    @FindBy(xpath = "//ms-button[@id='ms-button-0']//button")
    public WebElement receivers;
    @FindBy(xpath = "(//div[@class='mdc-checkbox'])[2]")
    public WebElement square;
    @FindBy(xpath = "//*[text()='Add & Close']")
    public WebElement addClose;
    @FindBy(xpath = "//input[@id='ms-text-field-0']")
    public WebElement subject;
    @FindBy(xpath = "//*[text()='Send']")
    public WebElement send;
    @FindBy(xpath = "//ms-confirm-button[@id='ms-button-2']")
    public WebElement rubbish;
    @FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base mdc-button--outlined mat-mdc-outlined-button mat-accent']")
    public WebElement yes;
    @FindBy(css = "ms-delete-button[id='ms-delete-button-0']")
    public WebElement permanentdelete;
    @FindBy(xpath = "//*[text()=' Delete ']")
    public WebElement delete;
    @FindBy(xpath = "//ms-standard-button[@id='ms-standard-button-42']")
    public WebElement restore;


    @FindBy(xpath = "//*[text()='Finance']")
    public WebElement finance;
    @FindBy(xpath = "//*[text()='My Finance']")
    public WebElement myFinance;
    @FindBy(xpath = "//*[text()=' Student_6 11A']")
    public WebElement student;
    @FindBy(xpath = "//*[text()='Fee/Balance Detail']")
    public WebElement feeBalance;
    @FindBy(xpath = "//div[@class='mdc-radio']")
    public WebElement stripe;
    @FindBy(xpath = "(//div[@class='mdc-form-field mat-internal-form-field'])[4]")
    public WebElement payment;
    @FindBy(xpath = "(//div[@class='mdc-form-field mat-internal-form-field'])[5]")
    public WebElement pay;
    @FindBy(xpath = "(//*[text()='Pay'])[2]")
    public WebElement payButton;
    @FindBy(xpath = "//ms-currency-field[@id='ms-currency-field-0']/input")
    public WebElement amount;
    @FindBy(css = "iframe[title='Secure payment input frame']")
    public  WebElement iframe;


    @FindBy(xpath = "//div[@class='p-CardNumberInput']/div/input")
    public WebElement cardNumber;

    @FindBy(xpath = "(//div[@class='p-Input'])[2]/input")
    public WebElement expirationDate;

}
