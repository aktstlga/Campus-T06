Feature: Grading Reports Navigation

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student should be able to view grading
    Given The user clicks the Grading button from the top navigation
    Then The Grading page should be displayed

