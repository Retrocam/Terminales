Feature: Search a product
  Scenario Outline: search a producto in movistar using the search bar
    Given I am in movistar.com
    When I search a product writing the "<word>" in the search bar
    Then I confirm the search message with the "<word>"
    Examples:
      | word |
      | audifonos  |
      | iphone     |
      | galaxy     |