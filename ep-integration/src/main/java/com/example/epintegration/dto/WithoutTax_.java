
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
    "unitDto",
    "value"
})
public class WithoutTax_ {

    @SerializedName("unitDto")
    private Unit_ unitDto;
    @SerializedName("value")
    private Value__ value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WithoutTax_() {
    }

    /**
     * 
     * @param unitDto
     * @param value
     */
    public WithoutTax_(Unit_ unitDto, Value__ value) {
        super();
        this.unitDto = unitDto;
        this.value = value;
    }

    @SerializedName("unitDto")
    public Unit_ getUnit() {
        return unitDto;
    }

    @SerializedName("unitDto")
    public void setUnit(Unit_ unitDto) {
        this.unitDto = unitDto;
    }

    @SerializedName("value")
    public Value__ getValue() {
        return value;
    }

    @SerializedName("value")
    public void setValue(Value__ value) {
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
