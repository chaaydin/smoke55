@apiregression @regression
Feature: Testing the Google Search Functionality Parameters
  Background:
    Given User navigates to the 'https://www.google.com/'


  Scenario: Happy Path (positive) testing for Search Parameters

    #Given User navigates to the 'https://www.google.com/'
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links

  Scenario: Happy Path(positive) Testing Result for Search Parameters
    #Given User navigates to the 'https://www.google.com/'
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is less than 300000000

    @smoke
  Scenario: Testing Loading Time for the Search Parameters
   # Given User navigates to the 'https://www.google.com/'
    When User searches for 'Turkish Baklava'
    Then User validates the loading time is less than 1.00
                                                            #if it was 1 instead of 1.00 you would get PM problem