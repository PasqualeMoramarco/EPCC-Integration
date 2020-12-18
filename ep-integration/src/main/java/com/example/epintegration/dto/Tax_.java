
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
public class Tax_ {

    @SerializedName("unit")
    private Unit__ unit;
    @SerializedName("value")
    private Value___ value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tax_() {
    }

    /**
     * 
     * @param unit
     * @param value
     */
    public Tax_(Unit__ unit, Value___ value) {
        super();
        this.unit = unit;
        this.value = value;
    }

    @SerializedName("unit")
    public Unit__ getUnit() {
        return unit;
    }

    @SerializedName("unit")
    public void setUnit(Unit__ unit) {
        this.unit = unit;
    }

    @SerializedName("value")
    public Value___ getValue() {
        return value;
    }

    @SerializedName("value")
    public void setValue(Value___ value) {
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
