
package com.example.epintegration.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "first_name",
    "last_name",
    "phone_number",
    "company_name",
    "line_1",
    "line_2",
    "city",
    "postcode",
    "county",
    "country",
    "instructions"
})
public class ShippingAddressDto {

    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("company_name")
    private String companyName;
    @SerializedName("line_1")
    private String line1;
    @SerializedName("line_2")
    private String line2;
    @SerializedName("city")
    private String city;
    @SerializedName("postcode")
    private String postcode;
    @SerializedName("county")
    private String county;
    @SerializedName("country")
    private String country;
    @SerializedName("instructions")
    private String instructions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShippingAddressDto() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param country
     * @param instructions
     * @param phoneNumber
     * @param city
     * @param companyName
     * @param postcode
     * @param county
     * @param line2
     * @param line1
     */
    public ShippingAddressDto(String firstName, String lastName, String phoneNumber, String companyName, String line1, String line2, String city, String postcode, String county, String country, String instructions) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.postcode = postcode;
        this.county = county;
        this.country = country;
        this.instructions = instructions;
    }

    @SerializedName("first_name")
    public String getFirstName() {
        return firstName;
    }

    @SerializedName("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @SerializedName("last_name")
    public String getLastName() {
        return lastName;
    }

    @SerializedName("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SerializedName("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @SerializedName("phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @SerializedName("company_name")
    public String getCompanyName() {
        return companyName;
    }

    @SerializedName("company_name")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @SerializedName("line_1")
    public String getLine1() {
        return line1;
    }

    @SerializedName("line_1")
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    @SerializedName("line_2")
    public String getLine2() {
        return line2;
    }

    @SerializedName("line_2")
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    @SerializedName("city")
    public String getCity() {
        return city;
    }

    @SerializedName("city")
    public void setCity(String city) {
        this.city = city;
    }

    @SerializedName("postcode")
    public String getPostcode() {
        return postcode;
    }

    @SerializedName("postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @SerializedName("county")
    public String getCounty() {
        return county;
    }

    @SerializedName("county")
    public void setCounty(String county) {
        this.county = county;
    }

    @SerializedName("country")
    public String getCountry() {
        return country;
    }

    @SerializedName("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @SerializedName("instructions")
    public String getInstructions() {
        return instructions;
    }

    @SerializedName("instructions")
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
