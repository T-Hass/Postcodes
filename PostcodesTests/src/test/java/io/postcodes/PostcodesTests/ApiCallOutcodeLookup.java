package io.postcodes.PostcodesTests;

import java.io.IOException;
import java.net.MalformedURLException;

public class ApiCallOutcodeLookup {

	public static OutcodeResponse outcodeLookup(String siteUrl, String outcode)
			throws MalformedURLException, IOException {

		String url = siteUrl + "/outcodes/" + outcode;

		// Make connection and get response in InputStream
		String jsonResponse = ApiTools.startConnectionGetResponse(url, "");

		// Parse JSON in jsonResponse into class postcodeResult
		OutcodeResponse outcodeResponse = ApiTools.parseOutcodeLookupJsonString(jsonResponse);

		return outcodeResponse;

	}
}
