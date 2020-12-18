
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
    "formatted"
})
public class Value___ {

    @SerializedName("amount")
    private Integer amount;
    @SerializedName("currency")
    private String currency;
    @SerializedName("formatted")
    private String formatted;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Value___() {
    }

    /**
     * 
     * @param amount
     * @param formatted
     * @param currency
     */
    public Value___(Integer amount, String currency, String formatted) {
        super();
        this.amount = amount;
        this.currency = currency;
        this.formatted = formatted;
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

    @SerializedName("formatted")
    public String getFormatted() {
        return formatted;
    }

    @SerializedName("formatted")
    public void setFormatted(String formatted) {
        this.formatted = formatted;
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
