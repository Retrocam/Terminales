Feature: Add a product to shopping cart
  Background: Availability
    Given I am in movistar.com
    When I select a product
  Scenario: Add to cart succesfully
    And I click on the button Buy now
    Then I validate the name of the product
    And I validate the price of the product