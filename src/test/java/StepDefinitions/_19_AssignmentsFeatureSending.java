package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.When;

public class _19_AssignmentsFeatureSending {
    DialogContent dc = new DialogContent();

        @When("Discussion click and Chats click")
        public void discussionClickAndChatsClick() {
            dc.jsClick(dc.discussion);
            dc.jsClick(dc.persons);
            dc.jsClick(dc.chats);
            dc.jsClick(dc.attachFiles);
        }
}
