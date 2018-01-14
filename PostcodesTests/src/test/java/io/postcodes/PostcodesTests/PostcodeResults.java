package io.postcodes.PostcodesTests;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import io.postcodes.PostcodesTests.CodeDetails;

public class PostcodeResults {
	// private String postcode;
	// private Integer quality;
	// private String eastings;
	// private String northings;
	// private String country;
	// private String nhsHa;
	// private Double logitude;
	// private Double latitude;
	// private String europeanElectoralRegion;
	// private String primaryCareTrust;
	// private String region;
	// private String lsoa;
	// private String msoa;
	// private String incode;
	// private String outcode;
	// private Double distance;
	// private String parliamentaryConstituency;
	// private String adminDistrict;
	// private String parish;
	// private String adminCounty;
	// private String adminWard;
	// private String ccg;
	// private String nuts;
	// private ArrayList<Codes> postcodeCodes;

	@SerializedName("postcode")
	private String postcode;
	@SerializedName("quality")
	private Integer quality;
	@SerializedName("eastings")
	private Integer eastings;
	@SerializedName("northings")
	private Integer northings;
	@SerializedName("country")
	private String country;
	@SerializedName("nhs_ha")
	private String nhsHa;
	@SerializedName("longitude")
	private Double logitude;
	@SerializedName("latitude")
	private Double latitude;
	@SerializedName("european_electoral_region")
	private String europeanElectoralRegion;
	@SerializedName("primary_care_trust")
	private String primaryCareTrust;
	@SerializedName("region")
	private String region;
	@SerializedName("lsoa")
	private String lsoa;
	@SerializedName("msoa")
	private String msoa;
	@SerializedName("incode")
	private String incode;
	@SerializedName("outcode")
	private String outcode;
	@SerializedName("distance")
	private Double distance;
	@SerializedName("parliamentary_constituency")
	private String parliamentaryConstituency;
	@SerializedName("admin_district")
	private String adminDistrict;
	@SerializedName("parish")
	private String parish;
	@SerializedName("admin_county")
	private String adminCounty;
	@SerializedName("admin_ward")
	private String adminWard;
	@SerializedName("ccg")
	private String ccg;
	@SerializedName("nuts")
	private String nuts;
	@SerializedName("codes")
	private CodeDetails postcodeCodes;

	public String getPostcode() {
		return postcode;
	}

	public Double getDistance() {
		return distance;
	}

	public String getOutcode() {
		return outcode;
	}
}
