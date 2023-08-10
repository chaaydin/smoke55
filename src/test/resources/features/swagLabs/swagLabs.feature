@regression
Feature: Testing Cart, Order and Item Prices Functionalities for SwagLabs Website

    Scenario Outline: Testing Cart, Order and Item Prices Functionalities via Scenario Outline for all items
      Given  The user is logged in successfully by providing username and password
      When The user clicks Add to cart button for chosen '<itemType>' item and validate it is added
      And  The user clicks cart icon on the top right of page
      When The user clicks checkout button
      And  The user fills out 'Cagatay' , 'Aydin' , '50505' fields and clicks continue button
      Then The user validates item name '<itemName>', product price <productPriceBeforeTax>, tax <tax> and total price <totalPrice>
      And  The user provides tax rate 0.08 for all items, then calculated total price should match the product price with tax
      When The user clicks finish button
      Then The user validates the message 'Thank you for your order!'
      Examples:

      |itemType  |       itemName          |productPriceBeforeTax|    tax    |    totalPrice  |
      |backpack  |Sauce Labs Backpack              |29.99|            2.40   |      32.39     |
      |bike light|Sauce Labs Bike Light            |9.99 |            0.80   |      10.79     |
      |bolt tee  |Sauce Labs Bolt T-Shirt          |15.99|            1.28   |      17.27     |
      |jacket    |Sauce Labs Fleece Jacket         |49.99|            4.00   |      53.99     |
      |baby      |Sauce Labs Onesie                |7.99 |            0.64   |      8.63      |
      |red tee   |Test.allTheThings() T-Shirt (Red)|15.99|            1.28   |      17.27     |
  @dalga
      @dataTable
      Scenario: Testing Cart, Order and Item Prices Functionalities via dataTable for baby clothes
        Given  The user is logged in successfully by providing username and password
        When The user clicks Add to cart button for chosen item type
        | item type | baby |
        And  The user clicks cart icon on the top right of page
        When The user clicks checkout button
        And  The user fills out name, last name, zip code fields and clicks continue button
        | name     | cafer |
        | last name| mcNeal|
        | zip code | 30303 |
        Then The user validates item name, product price, tax and total price
          |product name |Sauce Labs Onesie|
          |product price| 7.99|
          |      tax    | 0.64|
          |total price  | 8.63|
        And  The user provides tax rate 0.08 for all items, then calculated total price should match the product price with tax
        When The user clicks finish button
        Then The user validates the confirm message 'Thank you for your order!'





 #Scenario:
  #Given  The user is logged in successfully by providing username and password
    #When The user clicks Add to cart button for chosen 'baby' item
    #And  The user clicks cart sign on the top right of page
   # When The user clicks checkout button
    #And  The user fills out 'firstNameCagatay' , 'lastNameAydin' , 'zipCode60608' fields and clicks continue button
    #Then The user validates productName 'Sauce Labs Onesie', productPrice, tax and totalPrice by providing 7.99 as expectedProductPrice
   # When The user clicks finish button
    #Then The user validates the message 'Thank you for your order!'