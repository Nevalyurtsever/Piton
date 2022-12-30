@loginModule @smoke-test
Feature: US001 Login Module

  Background: User goes to homepage
    Given User is on the homepage

  @login-form
  Scenario:TC01 - User should see login form if not authenticated.Login Form should contain username password and login button
    Then User sees username input
    Then User sees password input
    Then User sees login button

  @login-form-negative
  Scenario:TC01-Negative - User should not see login form if authenticated.
    And User enters valid username
    And User enters valid password
    And User clicks login button
    And User is on the homepage
    Then User sees title "Events" instead of login form

  @login-form-validation-error
  Scenario: TC02 - User should see validation errors if click the login button without fill the login form
    And User clicks login button
    Then User sees validation errors

  @navigate-dashboard-page
  Scenario: TC03 - User should navigate to the dashboard and see welcome message if authenticate successfully
    And User enters valid username
    And User enters valid password
    And User clicks login button
    Then User sees dashboard page and welcome message







