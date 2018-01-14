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
	
	public static String startConnectionGetResponse(String url, String arguments) throws MalformedURLException, IOException {
		//		Opening connection
		URLConnection connection = new URL(url).openConnection();
		
//		No headers are needed
		
//		Getting response (InputStream) from the connection:
		InputStream response = connection.getInputStream();
		
//		Parse InputStream containing JSON response into a string
		String responseJson = parseResponseToString(response);

		return responseJson;
	}
	
	
	public static PostcodeResult parsePostcodeJsonString (String jsonString) {
//		Parse JSON in String into class PostcodeResult
		Gson requestGson = new Gson();
		PostcodeResult postcodeResults = requestGson.fromJson(jsonString, PostcodeResult.class);
		
		return postcodeResults;
	}
	
	
	public static PostcodeAutocompleteResult parsePostcodeAutoCompleteJsonString (String jsonString) {
//		Parse JSON in String into class PostcodeAutocompleteResult
		Gson requestGson = new Gson();
		PostcodeAutocompleteResult postcodeACResults = requestGson.fromJson(jsonString, PostcodeAutocompleteResult.class);
		
		return postcodeACResults;
		
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