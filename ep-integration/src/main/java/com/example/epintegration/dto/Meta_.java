
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
    "display_price",
    "timestamps"
})
public class Meta_ {

    @SerializedName("display_price")
    private DisplayPrice_ displayPrice;
    @SerializedName("timestamps")
    private Timestamps_ timestamps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta_() {
    }

    /**
     * 
     * @param displayPrice
     * @param timestamps
     */
    public Meta_(DisplayPrice_ displayPrice, Timestamps_ timestamps) {
        super();
        this.displayPrice = displayPrice;
        this.timestamps = timestamps;
    }

    @SerializedName("display_price")
    public DisplayPrice_ getDisplayPrice() {
        return displayPrice;
    }

    @SerializedName("display_price")
    public void setDisplayPrice(DisplayPrice_ displayPrice) {
        this.displayPrice = displayPrice;
    }

    @SerializedName("timestamps")
    public Timestamps_ getTimestamps() {
        return timestamps;
    }

    @SerializedName("timestamps")
    public void setTimestamps(Timestamps_ timestamps) {
        this.timestamps = timestamps;
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
