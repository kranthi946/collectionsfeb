Feature: Getting animals from the API

  Scenario: Validation of positive response code from get animals API
    Given I am an authenticated user
    When I hit the get animals API URL
    Then I get 200 as response code
    And I get animals in the response body of the API

  Scenario: Validation of positive response body from get animals API

    Given I am an authenticated user
    When I hit the get animals API URL
    Then I get animals in the response body of the API

  Scenario: Validation of negative response code from get animals API
    Given I am an unauthenticated user
    When I hit the get animals API URL without authentication
    Then I get 401 as the response code

  Scenario: Validation of negative response body from get animals API
    Given I am an unauthenticated user
    When I hit the get animals API URL without authentication
    Then I do not get animals in the response body of the API


