Feature: Assignments Buttons and Details Page Control

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Verify functionality of Info, Submit, and Mark it icons on assignment cards
    Given The user navigates to the Assignments page
    When The user clicks the "info" icon button on a random assignment card
    Then The user should see the assignment details page

    And The user returns to the Assignments page
    When The user clicks on an area of the assignment card excluding the icons
    Then The user should see the assignment details page

    And The user returns to the Assignments page
    When The user clicks the 'submit' icon on a random assignment card
    Then The user should see the submission dialog

