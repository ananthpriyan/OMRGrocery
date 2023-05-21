@Login
Feature: Login module API Automation

  Scenario: Get user logtoken from login endpoint
    Given User add header
    Then User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User verify the statuscode is 200
    And User verify the login response body firstname present as "Anandharaj" and get the logtoken saved
