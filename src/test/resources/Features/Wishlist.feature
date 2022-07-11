@All @Wishlist @Story3
Feature: Wishlist

  Scenario: Add book to wishlist
    Given user is on login page
    When user log in as member
    And user click a book at the list
    And user click add to wishlist button
    And user fill the wishlist name with "Plan to buy"
    And user click add button
    Then user will see message item added