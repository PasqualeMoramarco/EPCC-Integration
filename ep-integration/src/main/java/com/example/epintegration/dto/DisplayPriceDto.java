
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
public class DisplayPriceDto {

    @SerializedName("with_tax")
    private WithTaxDto withTaxDto;
    @SerializedName("without_tax")
    private WithoutTaxDto withoutTaxDto;
    @SerializedName("tax")
    private TaxDto taxDto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DisplayPriceDto() {
    }

    /**
     * 
     * @param withTaxDto
     * @param withoutTaxDto
     * @param taxDto
     */
    public DisplayPriceDto(WithTaxDto withTaxDto, WithoutTaxDto withoutTaxDto, TaxDto taxDto) {
        super();
        this.withTaxDto = withTaxDto;
        this.withoutTaxDto = withoutTaxDto;
        this.taxDto = taxDto;
    }

    @SerializedName("with_tax")
    public WithTaxDto getWithTax() {
        return withTaxDto;
    }

    @SerializedName("with_tax")
    public void setWithTax(WithTaxDto withTaxDto) {
        this.withTaxDto = withTaxDto;
    }

    @SerializedName("without_tax")
    public WithoutTaxDto getWithoutTax() {
        return withoutTaxDto;
    }

    @SerializedName("without_tax")
    public void setWithoutTax(WithoutTaxDto withoutTaxDto) {
        this.withoutTaxDto = withoutTaxDto;
    }

    @SerializedName("tax")
    public TaxDto getTax() {
        return taxDto;
    }

    @SerializedName("tax")
    public void setTax(TaxDto taxDto) {
        this.taxDto = taxDto;
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
