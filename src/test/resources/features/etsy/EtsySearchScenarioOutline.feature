Feature: Testing etsy search func with Scenario Outline

  Scenario Outline: Testing different products for Search Func

    When User searches for '<itemName>' for etsy Hat
    Then User validates the title '<title>' from etsy
    Examples:
    | itemName | title      |
    | Hat      | Hat - Etsy |
    | Key      | Key - Etsy |
    | Pin      | Pin - Etsy |
