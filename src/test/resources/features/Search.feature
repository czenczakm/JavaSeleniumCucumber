@Search
Feature: Search page

  Scenario Outline: Search on search page
    Given User is on Search page
    When User search for "<itemName>"
    Then "<numberOfResults>" results has been found
    Examples:
      | itemName              | numberOfResults |
      | some string           | 0               |
      | Blouse                | 1               |
      | PRINTED CHIFFON DRESS | 2               |
      | DRESS                 | 7               |

  Scenario Outline: Check the price of searched item
    Given User is on Search page
    When User search for "<itemName>"
    Then In results there is an item: "<itemName>" with the price: "<price>"
    Examples:
      | itemName                    | price  |
      | FADED SHORT SLEEVE T-SHIRTS | $16.51 |
      | DRESS                       | $30.50 |
