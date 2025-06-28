Feature: Assignments Submit functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student submits an assignment with rich text and attachments

    Given The user navigates to the Assignments page
    When The user clicks the 'submit' icon on a random assignment card
    Then The user should see the submission dialog

    And The user inputs a random message, table, and attached file into the rich text editor

    And The user saves the draft and then submits the assignment with a wait in between
    And The user confirms the submission by clicking "Yes"
    Then The user should see a success message confirming the submission