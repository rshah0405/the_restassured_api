Feature: Testing Users Functionality.



  Scenario: Check if user is able to get all USERS information by sending GET request
    When user sends a GET request to the USER Endpoint ,they must get back a valid status code 200


  Scenario: Create a new user & verify if the user is added
    When I create a new user by providing the information id,userName and password
    Then I verify the user is created and I get a valid status code

  Scenario: Getting user information by Id
    When I send GET request to users endpoint with Id, I should received the users information and I get valid status code 200

  Scenario: Update a created user & verify if the user is updated
    When  I update a created user providing the new userName "userName"
    Then I verify the user is updated and I get valid status code

  Scenario: Delete a created user & verify the user is deleted
    When I delete a created user ,I must get back a valid status code  200
    Then I verify the user is deleted




