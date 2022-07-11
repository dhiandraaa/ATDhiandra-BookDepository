@All @Sorting @Story1
Feature: Sorting low to high price

  Scenario: Search book
    Given user is on landing page
    When user click on the search bar
    And user enter "tree" into the search bar
    And user click on the search button
    Then user is navigated to search result page

  Scenario: Sort from low to high price
    Given user is on search result page
    When user click on search sort by dropdown
    And user click low to high price
    Then user will see a list of books sorted from the lowest price