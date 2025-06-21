Feature: Calendar functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student should be able to view calendar menu
    Given The user clicks the Calendar button from the top navigation on the home page
    When The user clicks on the lesson icon
    Then The lesson details should be visible
