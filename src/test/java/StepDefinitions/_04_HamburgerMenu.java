package StepDefinitions;

import Pages.HamburgerMenuPOM;
import Utilities.GWD;
import io.cucumber.java.en.*;

public class _04_HamburgerMenu {
    HamburgerMenuPOM H = new HamburgerMenuPOM();

    @Given("Effective Message Management with Messages Link in Hamburger Menu")
    public void effectiveMessageManagementWithMessagesLinkInHamburgerMenu() {
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

    @Given("Direct Communication with Teachers and Mentors by Sending Messages from the Hamburger Menu")
    public void directCommunicationWithTeachersAndMentorsBySendingMessagesFromTheHamburgerMenu() {
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

    @Given("Ease of Editing Messages with Deleting Outbox Messages from the Hamburger Menu")
    public void easeOfEditingMessagesWithDeletingOutboxMessagesFromTheHamburgerMenu() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.messaging);
        H.myClick(H.outbox);
        H.myClick(H.rubbish);
        H.myClick(H.yes);
    }

    @Given("Flexibility to Edit Messages with Undelete or Permanent Delete")
    public void flexibilityToEditMessagesWithUndeleteOrPermanentDelete() {
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

    @Given("Easy Online Payment Opportunity by Entering the Finance Section from the Hamburger Menu")
    public void easyOnlinePaymentOpportunityByEnteringTheFinanceSectionFromTheHamburgerMenu() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
    }

    @Given("Ease of Payment Tracking by Viewing Course Installment Details on the Finance Page")
    public void easeOfPaymentTrackingByViewingCourseInstallmentDetailsOnTheFinancePage() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
        H.myClick(H.student);
        H.myClick(H.feeBalance);
    }

    @Given("Payment Confirmation with Display of Decrease in Remaining Debt in Balance Section when I Make Payment")
    public void paymentConfirmationWithDisplayOfDecreaseInRemainingDebtInBalanceSectionWhenIMakePayment() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
        H.myClick(H.student);
        H.myClick(H.stripe);
        H.myClick(H.payment);
        GWD.getDriver().switchTo().frame(H.iframe);
        H.mySendKeys(H.cardNumber, "4242 4242 4242 4242");
        H.mySendKeys(H.expirationDate, "12/29");
        H.mySendKeys(H.securityCode, "305");
    }

    @Given("Paying Course Installments by Paying ${int} with Stripe Infrastructure")
    public void payingCourseInstallmentsByPaying$WithStripeInfrastructure(int arg0) {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
        H.myClick(H.student);
        H.myClick(H.stripe);
        H.myClick(H.fullPayment);
        H.myClick(H.pay);
        H.mySendKeys(H.amount, "235");
        H.myClick(H.fullPayment);
        H.myClick(H.pay);
        H.clickWithJS(H.payButton);
        GWD.getDriver().switchTo().frame(H.iframe);
        H.mySendKeys(H.cardNumber, "4242 4242 4242 4242");
        H.mySendKeys(H.expirationDate, "12/29");
        H.mySendKeys(H.securityCode, "305");
    }

    @Given("Downloading Total Payment Amount and Remaining Debt from Payment Page in Excel PDF Format")
    public void downloadingTotalPaymentAmountAndRemainingDebtFromPaymentPageInExcelPDFFormat() {
        H.myClick(H.hamburgerMenu);
        H.hoverOver(H.finance);
        H.myClick(H.myFinance);
        H.myClick(H.dowloading);
        H.myClick(H.excel);
    }
}
