Feature: Calendar functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student should be able to view video recording
    Given The user clicks the Calendar button
    When The user clicks on the lesson icon from the course name
    When The user clicks on the recording button
    Then The video should be visible accordingly
