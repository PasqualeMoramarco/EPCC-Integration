
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
    "unit",
    "value"
})
public class WithTax_ {

    @SerializedName("unit")
    private UnitDto unit;
    @SerializedName("value")
    private Value_ value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WithTax_() {
    }

    /**
     * 
     * @param unit
     * @param value
     */
    public WithTax_(UnitDto unit, Value_ value) {
        super();
        this.unit = unit;
        this.value = value;
    }

    @SerializedName("unit")
    public UnitDto getUnit() {
        return unit;
    }

    @SerializedName("unit")
    public void setUnit(UnitDto unit) {
        this.unit = unit;
    }

    @SerializedName("value")
    public Value_ getValue() {
        return value;
    }

    @SerializedName("value")
    public void setValue(Value_ value) {
        this.value = value;
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
