@State
Feature: State module API Automation

  Scenario: Verify user Get statelist through API
    Given User add headers for the statelist
    When User send the "GET" request for statelist endpoint
    Then User verify the statuscode is 200
    And User verify the statelist response message matches "Tamil Nadu" and save the state id
