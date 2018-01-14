package io.postcodes.PostcodesTests;

import java.io.IOException;
import java.net.MalformedURLException;

import io.postcodes.PostcodesTests.ApiTools;

public class ApiCallAutocomplete {

	public static PostcodeAutocompleteResult getAutocompletePostcodeSuggestions(String siteUrl, String postcode)
			throws MalformedURLException, IOException {

		String url = siteUrl + "/postcodes/" + postcode + "/autocomplete";

		// Make connection and get response in InputStream
		String jsonResponse = ApiTools.startConnectionGetResponse(url, "");

		// Parse JSON in jsonResponse into class postcodeAutocompleteResult
		PostcodeAutocompleteResult postcodeSuggestions = ApiTools.parsePostcodeAutoCompleteJsonString(jsonResponse);

		return postcodeSuggestions;

	}

}
