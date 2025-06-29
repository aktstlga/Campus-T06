package StepDefinitions;

import Pages.TopNav;

import io.cucumber.java.en.Then;

import org.openqa.selenium.WebElement;
import java.util.Arrays;

public class _18_Assignments {

    TopNav TN = new TopNav();

    @Then("The user prints detailed info of each assignment")
    public void printDetailedInfoOfEachAssignment() {
        TN.waitUntilAllVisible(TN.assignmentCards);
        TN.scrollToEachElement(TN.assignmentCards);

        int cardIndex = 1;
        for (WebElement card : TN.assignmentCards) {
            System.out.println("Assignment #" + cardIndex);

            String cardText = card.getText();
            String[] lines = cardText.split("\\n");

            String title = "";
            String project = "";
            String status = "";
            String submissionStatus = "";
            String dueDate = "";
            String point = "";
            String commentCount = "";

            for (String line : lines) {
                line = line.trim();

                if (line.matches("^\\d{2,}[A-Za-z\\- ]+")) {
                    title = line;
                } else if (line.contains("Project") || line.contains("HW") || line.contains("Assignment")) {
                    project = line;
                } else if (line.equalsIgnoreCase("Published")) {
                    status = line;
                } else if (line.contains("Submission Status")) {
                    submissionStatus = "Late";
                } else if (line.contains("Due Date")) {
                    int index = Arrays.asList(lines).indexOf(line);
                    if (index + 1 < lines.length) {
                        dueDate = lines[index + 1].trim();
                    }
                } else if (line.contains("Point") || line.contains("/")) {
                    point = line;
                } else if (line.matches("^\\d+$")) {
                    commentCount = line;
                }
            }
            System.out.println("   ➤ Title: " + title);
            System.out.println("   ➤ Project: " + project);
            System.out.println("   ➤ Status: " + status);
            System.out.println("   ➤ Submission: " + submissionStatus);
            System.out.println("   ➤ Due Date: " + dueDate);
            System.out.println("   ➤ Point: " + point);
            System.out.println("   ➤ Comment Count: " + commentCount);

            System.out.println("----------------------------------");
            cardIndex++;
        }
    }
}