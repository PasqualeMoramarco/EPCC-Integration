
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
public class MetaDto {

    @SerializedName("display_price")
    private DisplayPriceDto displayPriceDto;
    @SerializedName("timestamps")
    private TimestampsDto timestampsDto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MetaDto() {
    }

    /**
     * 
     * @param displayPriceDto
     * @param timestampsDto
     */
    public MetaDto(DisplayPriceDto displayPriceDto, TimestampsDto timestampsDto) {
        super();
        this.displayPriceDto = displayPriceDto;
        this.timestampsDto = timestampsDto;
    }

    @SerializedName("display_price")
    public DisplayPriceDto getDisplayPrice() {
        return displayPriceDto;
    }

    @SerializedName("display_price")
    public void setDisplayPrice(DisplayPriceDto displayPriceDto) {
        this.displayPriceDto = displayPriceDto;
    }

    @SerializedName("timestamps")
    public TimestampsDto getTimestamps() {
        return timestampsDto;
    }

    @SerializedName("timestamps")
    public void setTimestamps(TimestampsDto timestampsDto) {
        this.timestampsDto = timestampsDto;
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
