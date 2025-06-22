Feature: Logo button check

  Background: The user successfully logins
    Given Navigate to Campus
    When The user writes username and password and clicks on login button
    Then The user verifies login successfully

  Scenario: The user clicks on the login button, should be directed to TechnoStudy homepage
    Given The user verifies that is on Campus mainpage
    And Techno Study Logo on the left corner of page should be visible
    Then The user clicks on the Techno Study logo
    And The user should be directed to Techno Study mainpage