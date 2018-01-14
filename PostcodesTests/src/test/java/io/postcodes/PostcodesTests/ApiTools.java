package io.postcodes.PostcodesTests;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiTools {

	public static String startConnectionGetResponse(String url, String arguments)
			throws MalformedURLException, IOException {
		// Opening connection
		URLConnection connection = new URL(url).openConnection();

		// No headers are needed

		// Getting response (InputStream) from the connection:
		InputStream response = connection.getInputStream();

		// Parse InputStream containing JSON response into a string
		String responseJson = parseResponseToString(response);

		return responseJson;
	}

	public static PostcodeResponse parsePostcodeJsonString(String jsonString) {
		// Parse JSON in String into class PostcodeResult
		Gson requestGson = new Gson();
		PostcodeResponse postcodeResults = requestGson.fromJson(jsonString, PostcodeResponse.class);

		return postcodeResults;
	}

	public static PostcodeAutocompleteResponse parsePostcodeAutoCompleteJsonString(String jsonString) {
		// Parse JSON in String into class PostcodeAutocompleteResult
		Gson requestGson = new Gson();
		PostcodeAutocompleteResponse postcodeACResults = requestGson.fromJson(jsonString,
				PostcodeAutocompleteResponse.class);

		return postcodeACResults;

	}

	public static OutcodeResponse parseOutcodeLookupJsonString(String jsonString) {
		// Parse JSON in String into class OutcodeResponse
		Gson requestGson = new Gson();
		OutcodeResponse outcodeResponse = requestGson.fromJson(jsonString, OutcodeResponse.class);

		return outcodeResponse;
	}

	public static String parseResponseToString(InputStream response) {
		try (Scanner scanner = new Scanner(response)) {
			String string = "";
			string = string + scanner.useDelimiter("\\A").next();
			return string;
		}
	}

	public static String urlEncodeTool(String textToEncode) throws UnsupportedEncodingException {
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
		String encodedText = URLEncoder.encode(textToEncode, charset);
		return encodedText;
	}

}
