
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
    "data",
    "included"
})
public class OrderDto {

    @SerializedName("data")
    private DataDto dataDto;
    @SerializedName("included")
    private IncludedDto includedDto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderDto() {
    }

    public OrderDto(DataDto dataDto) {
        this.dataDto = dataDto;
    }

    /**
     * 
     * @param dataDto
     * @param includedDto
     */
    public OrderDto(DataDto dataDto, IncludedDto includedDto) {
        super();
        this.dataDto = dataDto;
        this.includedDto = includedDto;
    }

    @SerializedName("data")
    public DataDto getData() {
        return dataDto;
    }

    @SerializedName("data")
    public void setData(DataDto dataDto) {
        this.dataDto = dataDto;
    }

    @SerializedName("included")
    public IncludedDto getIncluded() {
        return includedDto;
    }

    @SerializedName("included")
    public void setIncluded(IncludedDto includedDto) {
        this.includedDto = includedDto;
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
