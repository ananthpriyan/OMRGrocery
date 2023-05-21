@ChangepofilePic
Feature: Change profile picture API Automation

  Scenario: Change profile picture in account
    Given User add header to change profile picture
    When User add form data for change profile picture
    And User send "POST" request type and endpoint to change profile picture
    Then User verify status code is 200
    And User verify profile picture response message matches "Profile updated Successfully"
