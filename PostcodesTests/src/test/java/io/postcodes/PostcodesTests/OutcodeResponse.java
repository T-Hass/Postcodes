package io.postcodes.PostcodesTests;

import com.google.gson.annotations.SerializedName;

public class OutcodeResponse {
	@SerializedName("status")
	private Integer status;
	@SerializedName("result")
	private OutcodeResult outcode;

}
