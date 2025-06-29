Feature: Assignment Search and Sort Functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student can use the search, filtering and sorting features on the Assignments page
    Given The user navigates to the Assignments page
    When The user selects a random predefined date range
    And The user selects a random category
    Then The user views the assignment category header
