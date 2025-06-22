Feature: Calendar functionality

  Background:
    Given Navigate to Campus
    When The user writes username and password and clicks on login button

  Scenario: Student should be able to view calendar
    Given The user clicks the Calendar button from the top navigation
    When The user clicks on the SideCalendar button and the Previous, Today, and Next icons
    Then The calendar view should update accordingly
