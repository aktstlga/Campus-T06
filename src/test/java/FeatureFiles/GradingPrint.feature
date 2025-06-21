Feature: Grading Reports Navigation

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student should be able to print document
    Given The user clicks the Grading button from the top navigation on home page
    When The user clicks the Print icon
    Then The document should be printable
