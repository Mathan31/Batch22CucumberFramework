@Complete
Feature: Ebay Product Search and Result Validation

  Background: Ebay Preconditions
    Given User should open chrome browser
    And User should navigate to Ebay url

  @Smoke @Sanity @Regression
  Scenario: Ebay Search using hard coded value from Step Definition
    When User enters the product Name and Product Catagory
    And User click on Search button
    Then User should see the search results page
    And Close the browser

  @Regression
  Scenario Outline: Ebay Search using multiple hard coded values from Feature file using scenario outline
    When User enters the multiple product Name as <ProductName> and Product multiple Catagory as <ProductCatagory>
    And User click on Search button
    Then User should see the search results page
    And Close the browser

    @Books
    Examples: 
      | ProductName | ProductCatagory |
      | Java        | Books           |
      | Selenium    | Books           |

    @Mobile
    Examples: 
      | ProductName | ProductCatagory           |
      | Lenovo      | Cell Phones & Accessories |
      | Samsung     | Cell Phones & Accessories |

  @Sanity @Regression
  Scenario: Ebay Search using hard coded value from Step Definition using Data Table as List of List
    When User enters the multiple product Name as datatable and multiple Product Catagory as datatable
      | ProductName | ProductCatagory           |
      | Selenium    | Books                     |
      | Mi          | Cell Phones & Accessories |
    Then User should see the search results page
    And Close the browser
