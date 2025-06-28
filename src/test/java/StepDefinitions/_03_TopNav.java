package StepDefinitions;

import Pages.TopNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _03_TopNav {
    TopNav topNav= new TopNav();
    @Given("The user clicks on the header menu:")
    public void theUserShouldClickTheFollowingMainMenuItems(DataTable datatable) {
        List<String> links = datatable.asList(String.class);
        ArrayList<String> urlParts = new ArrayList<>();
        Collections.addAll(urlParts,"grading","calendar","courses","attendance","assignment");
        for(int i = 0; i < links.size(); i++) {
           topNav.jsClick(topNav.topNavElements(links.get(i)));
           topNav.verifyUrlContains(urlParts.get(i));
        }
    }

}