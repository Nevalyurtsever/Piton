@dashboardModule @smoke-test
Feature: US003 Dashboard Module

  Background: User goes to homepage
    Given User is on the dashboard page

  Scenario: TC01 - User should view dashboard if authenticated
    And User enters valid username
    And User enters valid password
    And User clicks login button
    And User is on the dashboard page
    Then User sees title "Events" instead of login form

  Scenario: TC02 - User should redirect to login page if not authenticated
    Then User sees username input
    Then User sees password input
    Then User sees login button

  Scenario Outline: TC03 - User should view list of events if any event created otherwise user should view notification message states no registered event found
    And User enters valid username
    And User enters valid password
    And User clicks login button
    Then User sees message "No registered event has been found!!"
    And User clicks create event button
    And User enters event name <eventName>
    And User selects event date from date-picker
    And User enters participant <firstName> <lastName> <contact>
    When User clicks create new event button
    Then User sees <successfullyCreatedMessage> message and redirects dashboard page with <expectedEventName>
    Examples:
      | eventName      | firstName | lastName     | contact            | successfullyCreatedMessage   | expectedEventName |
      | "Test Event 3" | "Piton 3"   | "Event 3"  | "piton3@gmail.com" | "Event created successfully" | "Test Event 3"    |
      | "Test Event 4" | "Piton 4"   | "Event 4"  | "piton4@gmail.com" | "Event created successfully" | "Test Event 4"    |

  Scenario Outline: TC04 - User should be able navigate edit event when click the edit event button
    And User enters valid username
    And User enters valid password
    And User clicks login button
    And User clicks create event button
    And User enters event name <eventName>
    And User selects event date from date-picker
    And User enters participant <firstName> <lastName> <contact>
    And User clicks create new event button
    And User clicks edit event button
    Then User sees event edit page
    Examples:
      | eventName      | firstName | lastName     | contact            |
      | "Test Event 7" | "Piton 7"   | "Event 7"  | "piton7@gmail.com" |

  Scenario Outline: TC05 - User should be able to delete event when click the delete button
    And User enters valid username
    And User enters valid password
    And User clicks login button
    And User clicks create event button
    And User enters event name <eventName>
    And User selects event date from date-picker
    And User enters participant <firstName> <lastName> <contact>
    And User clicks create new event button
    And User clicks delete button
    Then User sees message "No registered event has been found!!"
    Examples:
      | eventName      | firstName | lastName     | contact            |
      | "Test Event 8" | "Piton 8"   | "Event 8"  | "piton8@gmail.com" |

  Scenario Outline: TC06 - User should be able to view event participants
    And User enters valid username
    And User enters valid password
    And User clicks login button
    And User clicks create event button
    And User enters event name <eventName>
    And User selects event date from date-picker
    And User enters participant <firstName> <lastName> <contact>
    And User clicks add participant button
    And User enters second participant "Neval" "Yurtsever" "contact@gmail.com"
    And User clicks create new event button
    And User clicks participants button
    Then User sees participants
    Examples:
      | eventName       | firstName  | lastName   | contact                |
      | "Test Event 10" | "Piton 10" | "Event 10" | "piton10@gmail.com"     |

