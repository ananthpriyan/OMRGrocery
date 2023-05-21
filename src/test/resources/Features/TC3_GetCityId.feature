@City
Feature: City module API Automation

  Scenario Outline: Verify user Get Citylist through API
    Given User add headers for the citylist
    When User add request body for the city list "<state_id>"
    And User send "POST" request for citylist and endpoint
    Then User verify the statuscode is 200
    And User verify citylist response message matches "Yercaud" and save the city id

    Examples: 
      | state_id |
      |          |
