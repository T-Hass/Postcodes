package io.postcodes.PostcodesTests;

import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class OutcodeResult {
	@SerializedName("outcode")
	private String outcode;
	@SerializedName("longitude")
	private Double longitude;
	@SerializedName("latitude")
	private Double latitude;
	@SerializedName("northings")
	private Integer northings;
	@SerializedName("eastings")
	private Integer eastings;
	@SerializedName("admin_district")
	private LinkedList<String> adminDistrict;
	@SerializedName("parish")
	private LinkedList<String> parish;
	@SerializedName("admin_county")
	private LinkedList<String> adminCounty;
	@SerializedName("admin_ward")
	private LinkedList<String> adminWard;
	@SerializedName("country")
	private LinkedList<String> country;
}
