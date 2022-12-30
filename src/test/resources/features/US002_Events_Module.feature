@eventsModule @smoke-test
  Feature: US002 Events Module

    Background: User should be login
      Given User is on the homepage
      And User enters valid username
      And User enters valid password
      And User clicks login button
      And User clicks create event button

    @create-event-form
    Scenario: TC01 - User should view create event form if click the Create Event button on dashboard
      Then User sees "Create Event" title
      Then User sees create new event button

    @create-event-form-validation-errors
    Scenario: TC02 - User should view validation errors if click the Create Event button without fill the event form
      When User clicks create new event button
      Then User sees create event form validation errors

    @add-participant
    Scenario: TC03 – User should be able to add new participant when click the Add Participant button
      When User clicks add participant button
      Then user sees new firstname, lastname and contact inputs for new participant

    @delete-all-participant
    Scenario: TC04 – User should view error message if removes all participants
      When User deletes all participants
      Then User sees participant error message

    @create-event
    Scenario Outline: TC05 - User should be able to create new event if fills all required fields and redirect to dashboard page with create successful message
      And User enters event name <eventName>
      And User enters event date <eventDate>
      And User enters participant <firstName> <lastName> <contact>
      When User clicks create new event button
      Then User sees <successfullyCreatedMessage> message and redirects dashboard page with <expectedEventName>
      Examples:
        | eventName    | eventDate    | firstName | lastName | contact          | successfullyCreatedMessage   | expectedEventName |
        | "Test Event" | "30/12/2022" | "Neval"   | "Test"   | "test@gmail.com" | "Event created successfully" | "Test Event"      |

    @create-event-2
    Scenario Outline: TC05(with date picker) - User should be able to create new event if fills all required fields and redirect to dashboard page with create successful message
      And User enters event name <eventName>
      And User selects event date from date-picker
      And User enters participant <firstName> <lastName> <contact>
      When User clicks create new event button
      Then User sees <successfullyCreatedMessage> message and redirects dashboard page with <expectedEventName>
      Examples:
        | eventName      | firstName | lastName | contact           | successfullyCreatedMessage   | expectedEventName |
        | "Test Event 2" | "Piton"   | "Event"  | "piton@gmail.com" | "Event created successfully" | "Test Event 2"    |

    @edit-event-page
    Scenario Outline: TC06(with date picker) - User should be able to edit event. When user click the edit button all event fields must be filled according to editing event
      And User enters event name <eventName>
      And User enters event description <description>
      And User selects event date from date-picker
      And User enters participant <firstName> <lastName> <contact>
      And User clicks create new event button
      When User clicks edit event button
      Then User sees event name <eventName> description <description> date <eventDate> firstname <firstName> lastname <lastName> contact <contact>
      Examples:
        | eventName      | description              | eventDate     | firstName   | lastName   | contact            |
        | "Test Event 3" | "Test description 3"     | "30/12/2022"  | "Neval 3"   | "Event 3"  | "piton3@gmail.com" |

    @create-event-successfully
    Scenario Outline: TC07(with date picker) - User should be able to update event if required fields filled and redirect to dashboard page with update successful message
      And User enters event name <eventName>
      And User selects event date from date-picker
      And User enters participant <firstName> <lastName> <contact>
      And User clicks create new event button
      And User clicks edit event button
      And User updates event name "Test Event 20"
      When User clicks update event button
      Then User sees <successfullyUpdatedMessage> message and redirects dashboard page with <expectedEventName>
      Examples:
        | eventName      | firstName   | lastName   | contact           | successfullyUpdatedMessage    | expectedEventName |
        | "Test Event 9" | "Piton 9"   | "Event 9"  | "piton@gmail.com" | "Event updated successfully"  | "Test Event 20"   |


