@SearchProduct
Feature: Search Product modul API Automation

  Scenario Outline: Verify user Search Product through API
    Given User add headers for the Search Product
    When User add request body to get Search Product "<text>"
    And User send "POST" request for Search Product and endpoint
    Then User verify the statuscode is 200
    And User verify the Search Product response message matches "OK"

    Examples: 
      | text |
      | nuts |