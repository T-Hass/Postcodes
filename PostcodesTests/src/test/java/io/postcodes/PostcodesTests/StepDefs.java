package io.postcodes.PostcodesTests;

import cucumber.api.java8.En;
import junit.framework.Assert;
import io.postcodes.PostcodesTests.ApiCallAutocomplete;

public class StepDefs implements cucumber.api.java8.En {
		
	String apiBaseUrl;
	String expectedResult;
	PostcodeAutocompleteResult postcodeACResponse;
	
	public StepDefs() {
		Given("^I am using (.+)$", (String url) -> {
			apiBaseUrl = url;
		});
		When("^autocomplete postcode is called for (.+)$", (String inputPostcode) -> {
			postcodeACResponse = ApiCallAutocomplete.getAutocompletePostcodeSuggestions(apiBaseUrl, inputPostcode);
		});

		Then("^(.+) should be one of the options$", (String expected) -> {
			Assert.assertTrue(postcodeACResponse.getPostCodeSuggestions().contains(expected));
		});
		Then("^a postcode which is known to not exist \\((.+)\\) should not be returned$", (String notExpected) -> {
			Assert.assertFalse(postcodeACResponse.getPostCodeSuggestions().contains(notExpected));
		});

	}
}
