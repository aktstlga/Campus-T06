Feature: Attendance functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student should be able to view attendance
    Given The user clicks the Attendance button from the top navigation
    When The user clicks on the Attendance Excecuses button
    Then The user should able to excecuses
    Then The user should able to reports into excecuses
