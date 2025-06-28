Feature: Top Navigation Main Menu Items Functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button
    Then The user verifies login successfully

  Scenario: All main menu items in the top navigation should be visible
    Given The user clicks on the header menu:
      | gradingButton     |
      | calendarButton    |
      | coursesButton     |
      | attendanceButton  |
      | assignmentsButton |
    Then The user clicks on the