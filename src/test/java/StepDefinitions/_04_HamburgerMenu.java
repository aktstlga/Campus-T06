package StepDefinitions;

import Pages.HamburgerMenuPOM;
import Utilities.GWD;
import io.cucumber.java.en.*;

public class _04_HamburgerMenu {
    HamburgerMenuPOM H = new HamburgerMenuPOM();

    @Given("Messaging clickable")
    public void messaging_clickable() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.sendMessage);
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.ınbox);
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.outbox);
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.trash);
    }

    @Given("send message")
    public void sendMessage() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.sendMessage);
        H.jsClick(H.receivers);
        H.myClick(H.square);
        H.myClick(H.addClose);
        H.mySendKeys(H.subject, "Hello");
        H.myClick(H.send);
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.outbox);
    }

    @Given("Delete message")
    public void deleteMessage() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.outbox);
        H.myClick(H.rubbish);
        H.myClick(H.yes);
    }

    @Given("permanent delete and message recovery")
    public void permanentDeleteAndMessageRecovery() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.trash);
        H.myClick(H.permanentdelete);
        H.myClick(H.delete);
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.trash);
        H.myClick(H.restore);
    }

    @Given("MY Finance click")
    public void myFinanceClick() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
    }

    @Given("MY Finance payment")
    public void myFinancePayment() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
        H.myClick(H.student);
        H.myClick(H.feeBalance);
    }

    @Given("Online payment")
    public void onlinePayment() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
        H.myClick(H.student);
        H.myClick(H.stripe);
        H.myClick(H.payment);
        GWD.getDriver().switchTo().frame(H.iframe);
        H.mySendKeys(H.cardNumber, "4242 4242 4242 4242");
        H.mySendKeys(H.cardNumber, "12/14");
    }

    @Given("Amount payment")
    public void amountPayment() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
        H.myClick(H.student);
        H.myClick(H.stripe);
        H.myClick(H.payment);
        H.myClick(H.pay);
        H.mySendKeys(H.amount,"235");
        H.myClick(H.payment);
        H.myClick(H.pay);
        H.clickWithJS(H.payButton);
    }
}
