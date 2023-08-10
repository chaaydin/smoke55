@regression
Feature: Testing the search funx of the etsy website
  Scenario: Search func happy path for Etsy Hat
    When User searches for 'Hat' for etsy Hat
    Then User validates the title 'Hat - Etsy' from etsy

  Scenario: Search func happy path for Etsy Hat
    When User searches for 'Key' for etsy Key
    Then User validates the title 'Key - Etsy' from etsy

  Scenario: Search func happy path for Etsy Hat
    When User searches for 'Pin' for etsy Pin
    Then User validates the title 'Pin - Etsy' from etsy