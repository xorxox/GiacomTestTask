Feature: Tasks For Tester Tech Test
  Rest of the task requiring Background feature for login

  Background:
    Given User will login and is on landing page

  Scenario:  User log out path
    Given User will logout
    When User will be on login page
    Then User cannot access landing page

  Scenario Outline: Challenging DOM
    Given User will open "Challenging DOM" page
    Then User will be able verify that "<VALUE>" in selected "<ROW>" and "<COLUMN_NAME>" is correct

    Examples:
      | COLUMN_NAME | ROW | VALUE         |
      | Sit         | 3   | Definiebas2   |
      | Amet        | 7   | Consequuntur6 |
      | Amet        | 8   | Consequuntur7 |

  Scenario: Not persistent checkboxes
    Given User will open "Checkboxes" page
    When Checkbox 2 is "checked"
    Then Set checkbox 2 to "unchecked"
    And Set checkbox 1 to "checked"
    And Reload page and verify default state is set

  Scenario: Page with entry advertisement
    Given User will open "Entry Ad" page
    Then User will close modal window

  Scenario: Basic inputs
    Given User will open "Inputs" page
    When User will fill "empty_data" form and submit it
    And User will fill "wrong_email_data" form and submit it
    And User will fill "all_correct_data" form and submit it
    Then User will verify form was accepted

  Scenario: JavaScript Alerts
    Given User will open "Javascript Alerts" page
    When User will click on "Click for JS Alert" button
    And User is able to close "alert" alert
    And User can see "successful" result
    And User will click on "Click for JS Confirm" button
    And User is able to close "confirm" alert
    And User can see "clicked" result
    And User will click on "Click for JS Prompt" button
    Then User is able to verify alert
    And User is able to fill alert with "check1" value
    And User can see "entered" result

  Scenario: Multiple Windows
    Given User will open "Multiple Windows" page
    When User will click on "Click Here" link
    And New window with text "New Window" is created
    Then User can close window and focus on windows page