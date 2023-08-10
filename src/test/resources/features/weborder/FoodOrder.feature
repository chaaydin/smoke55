#  #1-Login successfully weborder page parameterize username and password in feature file from CONFIG
#  #2 click the order box and next button
#  #3 send invitees section to "I LOVE SELENIUM"
#  #4 send inviteList "email@gmail.com" and "email2@gmail.com"
#  #5 choose the delivery option "My House" and validate adress(contains) "3137 Laguna"
#  #6 click group order button
#  #7 Validate the header "View Group Order"(think about thread.sleep) @Then
#  #8 Validate the description contains(Your group order is now pending) from description
  # and create another scenario for same order to OFFICE and validate
@regression
Feature: Testing Food Order Funx for WebOrder website

  Background: Food order same steps
      #execute for each scenarios until the keyword which is being tested at that point.
    Given User provides username and password for successful login
    When User clicks group order box, and next button
    And User provides note 'I LOVE SELENIUM' to invitees box
    And User provides emails "ahmet@aydin.com" , "cagatay@cafer.com" to inviteList


  Scenario: After Login successfully, validation of group order
      #Given User provides username and password for successful login
      #When User clicks group order box, and next button
     # And User provides note 'I LOVE SELENIUM' to invitees box
     # And User provides emails "ahmet@aydin.com" , "cagatay@cafer.com" to inviteList
    And User chooses delivery option to 'My House' and validates the address '3137 Laguna Street'
    And User clicks create group order button
    Then User validates 'View Group Order' and 'Your group order is now pending' from description

  Scenario: Testing Happy path for office food order
     # Given User provides username and password for successful login
      #When User clicks group order box, and next button
     # And User provides note 'I LOVE SELENIUM' to invitees box
     # And User provides emails "ahmet@aydin.com" , "cagatay@cafer.com" to inviteList
    And User chooses delivery option to 'Office' and validates the address '2012 EMPIRE BLVD'
    And User clicks create group order button
    Then User validates 'View Group Order' and 'Your group order is now pending' from description

