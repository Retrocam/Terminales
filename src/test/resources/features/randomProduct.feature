Feature: Select a random product
  Scenario: Find a product with stock
    Given I am in movistar.com
    When I select a random product
    Then I check if there is stock
    And I click on the button Buy now
    And I fill the personal data form
    And I fill the address form
    And I fill the Pay method form
    Then I verify the number order is not null