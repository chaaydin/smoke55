@regression
Feature: Testing the Login Funx for WebOrder Website
@smoke
  Scenario: Happy path (correct username- correct password) testing for login
    When User provides 'guest1@microworks.com' and 'Guest1!' and click Login button
    Then validate the 'ORDER DETAILS - Weborder'
@smoke
  Scenario: Negative login (Correct username - Wrong password)
    When User provides 'guest1@microworks.com' and 'asdasdsa' and click Login button
    Then User validates the message 'Sign in Failed'

  Scenario: Negative login (Wrong username - Correct password)
    When User provides 'adas@sada' and 'Guest1!' and click Login button
    Then User validates the message 'Sign in Failed'

  Scenario: Negative login (Empty username - Empty password)
    When User provides '' and '' and click Login button
    Then User validates the message 'Sign in Failed'


    #    https://demo.weborder.net with config
    #guest1@microworks.com not from config
    #Guest1! Not from config
    #
    #Create a feature file
    #1. Happy path login ve username and pws from feature validate title or url which is being provided by .feature as PM (ORDER DETAILS - Weborder or https://demo.weborder.net/GetAddress?ReturnURL=~/Ordering)
    #2. Correct UN, wrong pw validate “Sign in Failed”
    #3. Wrong UN, correct pw
    #4. Both empty validate
    #Username has to have @
    #Once you done activate your driver.quit
