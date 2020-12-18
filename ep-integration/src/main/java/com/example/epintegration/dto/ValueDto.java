
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
    "amount",
    "currency",
    "includes_tax"
})
public class ValueDto {

    @SerializedName("amount")
    private Integer amount;
    @SerializedName("currency")
    private String currency;
    @SerializedName("includes_tax")
    private Boolean includesTax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValueDto() {
    }

    /**
     * 
     * @param amount
     * @param includesTax
     * @param currency
     */
    public ValueDto(Integer amount, String currency, Boolean includesTax) {
        super();
        this.amount = amount;
        this.currency = currency;
        this.includesTax = includesTax;
    }

    @SerializedName("amount")
    public Integer getAmount() {
        return amount;
    }

    @SerializedName("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @SerializedName("currency")
    public String getCurrency() {
        return currency;
    }

    @SerializedName("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @SerializedName("includes_tax")
    public Boolean getIncludesTax() {
        return includesTax;
    }

    @SerializedName("includes_tax")
    public void setIncludesTax(Boolean includesTax) {
        this.includesTax = includesTax;
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
