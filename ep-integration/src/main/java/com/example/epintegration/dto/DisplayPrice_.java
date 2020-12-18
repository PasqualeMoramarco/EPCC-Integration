
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
    "with_tax",
    "without_tax",
    "tax"
})
public class DisplayPrice_ {

    @SerializedName("with_tax")
    private WithTax_ withTax;
    @SerializedName("without_tax")
    private WithoutTax_ withoutTax;
    @SerializedName("tax")
    private Tax_ tax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DisplayPrice_() {
    }

    /**
     * 
     * @param withTax
     * @param withoutTax
     * @param tax
     */
    public DisplayPrice_(WithTax_ withTax, WithoutTax_ withoutTax, Tax_ tax) {
        super();
        this.withTax = withTax;
        this.withoutTax = withoutTax;
        this.tax = tax;
    }

    @SerializedName("with_tax")
    public WithTax_ getWithTax() {
        return withTax;
    }

    @SerializedName("with_tax")
    public void setWithTax(WithTax_ withTax) {
        this.withTax = withTax;
    }

    @SerializedName("without_tax")
    public WithoutTax_ getWithoutTax() {
        return withoutTax;
    }

    @SerializedName("without_tax")
    public void setWithoutTax(WithoutTax_ withoutTax) {
        this.withoutTax = withoutTax;
    }

    @SerializedName("tax")
    public Tax_ getTax() {
        return tax;
    }

    @SerializedName("tax")
    public void setTax(Tax_ tax) {
        this.tax = tax;
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
