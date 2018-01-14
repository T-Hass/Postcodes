package io.postcodes.PostcodesTests;

import java.io.IOException;
import java.net.MalformedURLException;

import io.postcodes.PostcodesTests.ApiTools;

public class ApiCallLatLongLookup {

	public static PostcodeResponse postcodeLatLongLookup(String siteUrl, Double latitude, Double longitude)
			throws MalformedURLException, IOException {

		String url = siteUrl + "/postcodes?lon=" + ApiTools.urlEncodeTool(longitude.toString()) + "&lat="
				+ ApiTools.urlEncodeTool(latitude.toString());

		// Make connection and get response in InputStream
		String jsonResponse = ApiTools.startConnectionGetResponse(url, "");

		// Parse JSON in jsonResponse into class postcodeResult
		PostcodeResponse postcodeResult = ApiTools.parsePostcodeJsonString(jsonResponse);

		return postcodeResult;
	}

}
