Feature: Login functionality

  Scenario: Login with invalid username and password

    Given Navigate to Campus
    When The user writes invalid username and password
    And The user clicks on login button
    Then The user gets notification about invalid credentials

  Scenario: Login with valid username and password

    Given Navigate to Campus
    When The user writes username and password and clicks on login button
    Then The user verifies login successfully