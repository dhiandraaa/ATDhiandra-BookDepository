@All @MyBasket @Story2
Feature: My basket

  Scenario: Add a book in my basket
    Given user is in landing page
    When user click add to basket on a book
    And pop up item added appears
    And user click basket or checkout button
    Then user is navigated to your basket page
    And user click quantity dropdown
    And user click the higher value
    Then user will see the value beside increase the basket icon
    And user click quantity dropdown
    And user click the lower value
    Then user will see the value decrease beside the basket icon
    And user click remove button
    Then the book will disappear from the list