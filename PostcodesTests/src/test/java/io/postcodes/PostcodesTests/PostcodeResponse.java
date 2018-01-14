package io.postcodes.PostcodesTests;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class PostcodeResponse {

	@SerializedName("status")
	private Integer status;
	@SerializedName("result")
	private LinkedList<PostcodeResults> postcodes;

	public LinkedList<PostcodeResults> getPostcodeResults() {
		return postcodes;
	}
}
