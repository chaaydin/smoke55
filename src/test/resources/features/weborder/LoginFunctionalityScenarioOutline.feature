Feature: testing the login func for weborder website Scenario Outline
  @smoke
  Scenario: Happy path (correct username- correct password) testing for login
    When User provides 'guest1@microworks.com' and 'Guest1!' and click Login button
    Then validate the 'ORDER DETAILS - Weborder'

    Scenario Outline:
      When User provides '<username>' and '<password>' and click Login button
      Then User validates the message '<errorMsg>'
      Examples:
      | username                   |   password      | errorMsg        |
      | guest1@microworks.com      |   asdasdasd     | Sign in Failed  |
      | asd@sdas.com               |   Guest1!       | Sign in Failed  |
      |                            |                 | Sign in Failed  |
