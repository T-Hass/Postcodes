package io.postcodes.PostcodesTests;

import java.util.LinkedList;

import cucumber.api.java8.En;
import junit.framework.Assert;
import io.postcodes.PostcodesTests.ApiCallAutocomplete;
import io.postcodes.PostcodesTests.ApiCallLatLongLookup;
import io.postcodes.PostcodesTests.PostcodeResponse;
import io.postcodes.PostcodesTests.PostcodeResults;

public class StepDefs implements cucumber.api.java8.En {

	String apiBaseUrl;
	String expectedResult;
	PostcodeAutocompleteResult postcodeACResponse;
	PostcodeResponse postcodeResult;

	public StepDefs() {

		Given("^I am using (.+)$", (String url) -> {
			apiBaseUrl = url;
		});

		// Steps for Scenario 1
		When("^autocomplete postcode is called for (.+)$", (String inputPostcode) -> {
			postcodeACResponse = ApiCallAutocomplete.getAutocompletePostcodeSuggestions(apiBaseUrl, inputPostcode);
		});
		Then("^(.+) should be one of the options$", (String expected) -> {
			Assert.assertTrue(postcodeACResponse.getPostCodeSuggestions().contains(expected));
		});
		Then("^a postcode which is known to not exist \\((.+)\\) should not be returned$", (String notExpected) -> {
			Assert.assertFalse(postcodeACResponse.getPostCodeSuggestions().contains(notExpected));
		});

		// Steps for Scenario 2
		When("^lat long lookup is called for \\(([0-9\\.-]+), ([0-9\\.-]+)\\)$",
				(Double latitude, Double longitude) -> {
					postcodeResult = ApiCallLatLongLookup.postcodeLatLongLookup(apiBaseUrl, latitude, longitude);
				});
		Then("^more than one postcode should be returned$", () -> {
			Assert.assertTrue(postcodeResult.getPostcodeResults().size() >= 1);
		});
		Then("^all postcodes should have Outcode (.+)$", (String outcode) -> {
			postcodeResult.getPostcodeResults().forEach((PostcodeResults postcode) -> {
				Assert.assertEquals(outcode, postcode.getOutcode());
			});
		});
		Then("^(.+) should be ([0-9\\.-]+) away$", (String postcode, Double distance) -> {
			LinkedList<PostcodeResults> allresults = postcodeResult.getPostcodeResults();

			boolean foundPostcode = false;

			for (PostcodeResults pc : allresults) {
				if (pc.getPostcode().equals(postcode)) {
					foundPostcode = true;
					Assert.assertEquals(distance, pc.getDistance());
					break;
				}
			}
			Assert.assertTrue(foundPostcode);
		});

	}
}
