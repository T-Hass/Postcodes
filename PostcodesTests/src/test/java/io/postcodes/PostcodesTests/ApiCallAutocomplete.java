package io.postcodes.PostcodesTests;

import java.io.IOException;
import java.net.MalformedURLException;

import io.postcodes.PostcodesTests.ApiTools;

public class ApiCallAutocomplete {

	public static PostcodeAutocompleteResponse getAutocompletePostcodeSuggestions(String siteUrl, String postcode)
			throws MalformedURLException, IOException {

		String url = siteUrl + "/postcodes/" + postcode + "/autocomplete";

		// Make connection and get response in InputStream
		String jsonResponse = ApiTools.startConnectionGetResponse(url, "");

		// Parse JSON in jsonResponse into class postcodeAutocompleteResult
		PostcodeAutocompleteResponse postcodeResponse = ApiTools.parsePostcodeAutoCompleteJsonString(jsonResponse);

		return postcodeResponse;

	}

}
