package io.postcodes.PostcodesTests;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class PostcodeAutocompleteResult {
	@SerializedName("status")
	private Integer status;
	@SerializedName("result")
	private LinkedList<String> postcodeSuggestions;
	
	public LinkedList<String> getPostCodeSuggestions() {
		return postcodeSuggestions;
	}
}