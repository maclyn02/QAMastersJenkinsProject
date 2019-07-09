@regression
Feature: Checkout feature for www.automationpractice.com
  As a user
  I want to see a list of products,
  choose delivery and payment options
  and be able to make purchases successfully

  @bankwireCheckout @smoke @checkout
  Scenario: User can checkout using bankwire payment(with initial login)
    Given User opens the home page
    And User is logged in with email as "like@hostguru.info" and password as "like@hostguru.info" and prepared to checkout
    When User hovers over cart icon and clicks checkout button
    Then User should see order page
    When User clicks proceed to checkout button on order summary page
    Then User should see delivery address options
    When User verifies delivery address
    And User clicks proceed to checkout button on address page
    Then User should see shipping information
    When User ticks checkbox for terms and conditions
    And User clicks proceed to checkout button on shipping page
    Then User should be payment options
    When User clicks on Pay by Bank Wire link
    Then User should see bank wire payment details
    When User clicks I confirm my order button
    Then User should see order confirmation

  @chequeCheckout1 @smoke @checkout
  Scenario: User can checkout using cheque payment(with initial login)
    Given User opens the home page
    And User is logged in with email as "like@hostguru.info" and password as "like@hostguru.info" and prepared to checkout
    When User hovers over cart icon and clicks checkout button
    Then User should see order page
    When User clicks proceed to checkout button on order summary page
    Then User should see delivery address options
    When User verifies delivery address
    And User clicks proceed to checkout button on address page
    Then User should see shipping information
    When User ticks checkbox for terms and conditions
    And User clicks proceed to checkout button on shipping page
    Then User should be payment options
    When User clicks on Pay by Cheque link
    Then User should see cheque payment details
    When User clicks I confirm my order button
    Then User should see order confirmation


  @chequeCheckout2 @smoke @checkout
  Scenario: User can checkout using cheque payment(without initial login)
    Given User opens the home page
    And User is prepared to checkout
    When User hovers over cart icon and clicks checkout button
    Then User should see order page
    When User clicks proceed to checkout button on order summary page
    Then User should see authentication page
    When User enters email "like@hostguru.info" and password "like@hostguru.info"
    And User clicks on sign-in button
    Then User should see delivery address options
    When User verifies delivery address
    And User clicks proceed to checkout button on address page
    Then User should see shipping information
    When User ticks checkbox for terms and conditions
    And User clicks proceed to checkout button on shipping page
    Then User should be payment options
    When User clicks on Pay by Cheque link
    Then User should see cheque payment details
    When User clicks I confirm my order button
    Then User should see order confirmation