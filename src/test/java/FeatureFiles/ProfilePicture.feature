Feature: Profile Picture functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student successfully uploads and saves a new profile picture
    When The user navigates to profile settings
    And The user uploads a new profile picture
    Then The user clicks the save button
