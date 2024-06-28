Feature: Buy a product of each brand
  Scenario Outline: buy a producto of alls brands
    Given I am in "<urlBrand>"
    When I select a random product
    Then I check if there is stock
    And I click on the button Buy now
    And I fill the personal data form
    And I fill the address form
    And I fill the Pay method form
    Then I verify the number order is not null
    Examples:
      | nameBrand | urlBrand |
      | apple     | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=46  |
      | xiaomi    | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=200 |
      | oppo      | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=196 |
      | samsung   | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=51  |
      | vivo      | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=199 |
      | Huawei    | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=47  |
      | Nokia     | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=49  |
      | Motorola  | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=195 |
      | Realme    | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=197 |
      | Honor     | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=330 |
      | Microsoft | https://integration-5ojmyuq-jvrr247te2phq.us-5.magentosite.cloud/celulares.html?marca=229 |
