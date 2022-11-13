Feature: Trello feature api

  Scenario: Add a new list to test board after title change
    Given The board exists and contains the correct interaction
    When I change the board title to " New title"
    And I check that board name was updated to "New title"
    Then I add list with title " Example list" to the board
    And I delete newly created list