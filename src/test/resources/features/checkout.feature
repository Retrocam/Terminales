Feature: Fill the checkout form
  Background: Availability
    Given I am in movistar.com
    When I select a product
    And I click on the button Buy now
  Scenario: Fill the form succesfully
    And I fill the personal data form
    And I fill the address form
    And I fill the Pay method form
    Then I verify the number order is not null