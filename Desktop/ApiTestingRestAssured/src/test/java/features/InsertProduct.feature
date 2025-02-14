Feature: Insert product using POST API

  Scenario Outline: Validate POST product API works correctly with dynamic product title
    Given I set the base URI to "https://fakestoreapi.com"
    When I send a POST request to /products with product title "<ProductTitle>"
    Then I receive a response with status code 200
    And the response body should contain the following title: "<ProductTitle>"

    Examples:
      | ProductTitle  |
      | Shoes         |
      | T-shirt       |
      | Laptop        |