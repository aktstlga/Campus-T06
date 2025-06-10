package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends ParentPages {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css="[formcontrolname='username']")
    public WebElement username;

    @FindBy(css="[formcontrolname='password']")
    public WebElement password;

    @FindBy(css="span[class='mdc-button__label']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='Invalid username or password']")
    public WebElement invalidNotification;

    @FindBy(css = "span[class='username mr-12']")
    public WebElement studentCheck;
}