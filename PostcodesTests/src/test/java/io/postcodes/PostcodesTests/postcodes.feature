Feature: Postcodes.io API

  Scenario: To check postcode autocomplete only returns postcodes which exist
    Given I am using http://api.postcodes.io
    # The above is included to allow tests to easily be pointed to a new API version (e.g. staging)
    When autocomplete postcode is called for DN208A
    Then DN20 8AA should be one of the options
    And a postcode which is known to not exist (DN20 8AB) should not be returned

  Scenario Outline: To check postcode lookup by latitude and longitude
    Given I am using http://api.postcodes.io
    When lat long lookup is called for (<latitude>, <longitude>)
    Then more than one postcode should be returned
    And all postcodes should have Outcode <outcode>
    And <postcode> should be <distance> away

    Examples: 
      | latitude  | longitude | outcode | postcode | distance    |
      | 51.469761 | -0.140898 | SW8     | SW8 3LH  | 25.68607488 |
      | 53.371137 | -1.485651 | S11     | S11 8JJ  |  1.75609711 |
      | 53.343246 | -1.775370 | S33     | S33 8WF  | 23.23899339 |

  Scenario: 
    Given I am using http://api.postcodes.io
    When 11S outcode is used for outward code lookup
    #Then there should be no result returned
