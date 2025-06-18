Feature: Profile Theme functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student tries all themes and saves them
    Given The user navigates to profile settings
    And The user selects all themes one by one and saves