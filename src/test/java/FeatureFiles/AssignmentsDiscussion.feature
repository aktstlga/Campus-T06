Feature: Assignments Discussion functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student starts a discussion and shares opinions about the assignment
    Given The user navigates to the Assignments page
    When The user clicks on a random discussion button
    Then The discussion panel should be displayed

    When The user types message "Deneme" into the input field
    And The user clicks the send button
    Then The user closes the discussion dialog

    When The user clicks on a random discussion button
    And The user clicks on the Chats icon in the discussion panel
    And The user should be able to view previously initiated discussions
    Then The user closes the discussion dialog

    When The user clicks on a random discussion button
    And The user uploads a file using Robot
