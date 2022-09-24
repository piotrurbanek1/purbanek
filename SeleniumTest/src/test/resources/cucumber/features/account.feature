Feature: Hotel Users

  Scenario Outline: new address will can be added for users

    Given open browser with https://mystore-testlab.coderslab.pl
    And user is registered with <mail> and <password>
    When new address added with <alias> and <address> and <city> and <zipcode> and <phone>
    Then new address is created
    And new address is deleted and driver quit


    Examples:
     | mail |password| alias | address | city   | zipcode  | phone |
      |aaas@gmail.com| 12345 | glowna | glowna  | Warsawa | 11111 | 123456789 |
