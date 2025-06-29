package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.*;


public class _18_AssignmentsFeature {
    DialogContent dc=new DialogContent();

    @Given("Assignments Feature click")
    public void assignments_feature_click() {
        dc.hoverOver(dc.assignments);
        dc.myClick(dc.assignments);

    }
}
