#1-First Create your hook class and your @Before and @After annotation(io.cucumber)
#2-Read username,password,url from configuration.properties
#3-Start writing your test case in feature file
#4-Start creating your Page object model(pages,step definitions,runners)
#  tips:You should have :LoginPage,MainPage,OrderPage,ViewOrderPage(validation part)
#  tips:You should have :OrderCreationStepDef
#5-Create your runner class and get the all snips from Runner class(DryRun=True)
#6-Put the snips in step def class
#7-Start implementing your page classes(WebElements and Methods)
#8-Convert the logic of Scenario to Scenario Outline
#  -->Check it for MyMoney,FamilyAlbum,ScreenSaver
#  -->Check it for Visa,MasterCard,AmericanExpress
# TIPS: after login successfulyl  click order and fill out the fields and validate"New order has been successfully added."
  #(Card type should provide by. feature). After that click view order page and validate the list
  #After that use DataTable to provide Datas for only MyMoney



@regression
Feature: testing the order creation functionality for smartbear website
  Scenario: creating the weborder from smartbear
    Given User provides username and password for successfully login
    When User clicks order link on main page
    And User provides 'MyMoney' and '5' for product information
    And User provides 'cafer', '123 Randolph','miami', 'FL','32812' for address information
    And User provides 'VISA', '123456', '05/26' for payment information
    Then User click process button and validates the 'New order has been successfully added.'
    When User clicks view all orders link
    Then User validates all information 'cafer', 'MyMoney','5','123 Randolph','miami','FL','32812','Visa','123456','05/26' from table

  Scenario Outline: creating the weborder from smartbear with Scenario Outline
    Given User provides username and password for successfully login
    When User clicks order link on main page
    And User provides '<ProductType>' and '<Quantity>' for product information
    And User provides '<Name>', '<Street>','<City>', '<State>','<Zip>' for address information
    And User provides '<CardType>', '<CardNumber>', '<ExpireDate>' for payment information
    Then User click process button and validates the 'New order has been successfully added.'
    When User clicks view all orders link
    Then User validates all information '<Name>', '<ProductType>','<Quantity>','<Street>','<City>','<State>','<Zip>','<CardType>','<CardNumber>','<ExpireDate>' from table
    Examples:
      |ProductType|Quantity|Name | Street | City  |State| Zip |CardType        |CardNumber|ExpireDate|
      |MyMoney    |50      |cafer| 123Main| miami | FL  |60222|Visa            |12345678  |05/26     |
      |FamilyAlbum|150     |berk | 55Local| tampa | FL  |32422|American Express|34567890  |01/24     |
      |ScreenSaver|5       |john | 0blvd  | cape  | FL  |55077|MasterCard      |90123456  |08/28     |
@cagatay
    Scenario: creating the weborder from smartbear with DataTable
      Given User provides username,password for successfully login with DataTable
      When User clicks order link on main page with DataTable
      And User provides the product and quantity for product information
      |ProductType| MyMoney |
      |Quantity   |  50     |
      And User provides Name,street,city,state,zip for address information
      |Name   | cafer     |
      |street | 123 Main  |
      |city   |   miami   |
      |state  |  FL       |
      |zip    |  60222    |
      And User provides cardType, cardNumber, expireDate for payment information
        |CardType   |  Visa           |
        |CardNumber |  12345678     |
        |ExpireDate |  05/26        |
      Then User click process button and validates the message
       |New order has been successfully added. |

