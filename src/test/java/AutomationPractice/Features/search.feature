@regression
Feature: Search feature for www.automationpractice.com
  As a user
  I want to see a set of results when I search for a product

  #happy path scenario
  @validSearch @smoke @searchScenario
  Scenario: User can search for products using descriptive keywords
    Given User opens home page
    When User types search keyword as "Dresses"
    And User clicks on search icon
    Then User should be redirected to search page
    And User should see product list


  #un-happy path scenario
  @invalidSearch @smoke @searchScenario
  Scenario: User cannot search for products using blank search field
    Given User opens home page
    When User leaves search field blank
    And User clicks on search icon
    Then User should be redirected to search page
    And User should see search error message as "Please enter a search keyword"

  @invalidSearch @smoke @searchScenario
  Scenario: User cannot search for products using random combination of characters
    Given User opens home page
    When User types search keyword as "hfhgvhg#$$"
    And User clicks on search icon
    Then User should be redirected to search page
    And User should see search message as "No results were found for your search"