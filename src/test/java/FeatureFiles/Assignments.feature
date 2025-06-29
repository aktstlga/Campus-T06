Feature: Viewing assigned tasks from the Assignments link on homepage

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Verify that the Assignments link is visible and clickable on homepage
    Given The user navigates to the Assignments page
    Then The user prints detailed info of each assignment