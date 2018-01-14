
Feature: Postcodes.io API

Scenario: To check postcode autocomplete only returns postcodes which exist
	Given I am using http://api.postcodes.io
	# The above is included to allow tests to easily be pointed to a new API version (e.g. staging)
	When autocomplete postcode is called for DN208A
	Then DN20 8AA should be one of the options
	And a postcode which is known to not exist (DN20 8AB) should not be returned

