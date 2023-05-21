@Address
Feature: Address module API Automation

  @Add
  Scenario Outline: Verify add user address to the application through API
    Given User add headers and bearer authorization for accessing add address
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>",<state>,<city>,<country>,"<zipcode>","<address>" and "<address_type>"
    And User send "POST" request and endpoint for adduseraddress
    Then User verify the statuscode is 200
    And User verify the add User Address response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Ananth     | Priyan    | 9003845731 | appaswamy |    35 | 4440 |     101 |  600100 | Chennai | Home         |

  @Update
  Scenario Outline: Verify update user address to the application through API
    Given User add headers and bearer authorization for accessing update address
    When User add request body for update new address "<address_id>","<first_name>","<last_name>","<mobile>","<apartment>",<state>,<city>,<country>,"<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request and endpoint for update user address
    Then User verify the statuscode is 200
    And User verify the update User Address response message matches "Address updated successfully"

    Examples: 
      | address_id | first_name | last_Name | mobile     | apartment | state | city | country | zipcode | address      | address_type |
      |      46260 | Ananth     | Priyan    | 9003845731 | appaswamy |    35 | 4440 |     101 |  600100 | Kallakurichi | Home         |

  @Get
  Scenario: Verify get user address to the application through API
    Given User add headers and bearer authorization for accessing get address
    When User send "GET" request and endpoint to get user address
    Then User verify the statuscode is 200
    And User verify the get User Address response message matches "OK"

  @Delete
  Scenario Outline: Verify delete user address to the application through API
    Given User add headers and bearer authorization for accessing delete address
    When User add request body for delete user address "<address_id>"
    And User send "DELETE" request and endpoint to delete User address
    Then User verify the statuscode is 200
    And User verify the delete User Address response message matches "Address deleted successfully"

    Examples: 
      | address_id |
      |      46260 |
