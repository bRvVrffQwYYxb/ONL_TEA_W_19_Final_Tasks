Feature: Add a new address on MyStore

Scenario Outline: Add a new address on MyStore user account
  Given An open browser with https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account site
  When User signs in
  And User clicks Add fist address or Create new address button
  And User fills New address form with <alias> <address> <postcode> <city> <phone>
  And User clicks SAVE button
  Then User sees "Address successfully added!"
  And User deletes this address
  Then He sees "Address successfully deleted!"

  Examples:
    |alias        |address            |postcode  |city        |phone         |
    |London       |10 Downing Street  |SW1A 2AA  |London      |+447764729635 |
    |Manchester   |98 King St         |M2 4WU    |Manchester  |+447529188234 |
    |Leeds        |5 Calverley St     |LS1 3DA   |Leeds       |+447883196637 |
    |Bognor Regis |64 Hook Lane       |PO22 8AR  |Bognor Regis|+447883200468 |
    |Liverpool    |6 Tithebarn St     |L2 2DP    |Liverpool   |+447883269920 |
