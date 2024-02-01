Feature: Detect if a product has stock
  Scenario: Find a product with stock
    Given I am in movistar.com
    When I select a product
    Then I check if there is stock