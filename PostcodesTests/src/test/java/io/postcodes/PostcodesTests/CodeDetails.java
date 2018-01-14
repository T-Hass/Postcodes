package io.postcodes.PostcodesTests;

import com.google.gson.annotations.SerializedName;

public class CodeDetails {
	@SerializedName("admin_district")
	private String adminDistrict;
	@SerializedName("admin_county")
	private String adminCounty;
	@SerializedName("admin_ward")
	private String adminWard;
	@SerializedName("parish")
	private String parish;
	@SerializedName("parliamentary_constituency")
	private String parliamentaryConstituency;
	@SerializedName("ccg")
	private String ccg;
	@SerializedName("nuts")
	private String nuts;
	
}

