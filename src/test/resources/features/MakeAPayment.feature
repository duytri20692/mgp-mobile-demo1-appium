@MakeAPayment
Feature: Make a payment.

  Scenario: Verify user can make a payment after login to the system.
    Given User open the EriBank application and go to the Sign in page
    And User Login to the app with valid Username and Password
    And User should able to see EriBank homepage
    And User should see the current payment amount value is <100.00>
    When User press on the Make Payment button
    And User input information as the below
      | phone     | 81906918118 |
      | name      | Mark        |
      | amount(%) | 20          |
      | country   | Canada      |
    And User click on the Send Payment button
    And User click on confirm Yes to send the payment popup
    Then User should see the current payment amount value is <80.00>