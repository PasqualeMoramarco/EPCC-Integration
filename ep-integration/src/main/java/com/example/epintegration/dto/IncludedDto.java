
package com.example.epintegration.dto;

import java.util.HashMap;
import java.util.List;
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
    "items"
})
public class IncludedDto {

    @SerializedName("items")
    private List<ItemDto> itemDtos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IncludedDto() {
    }

    /**
     * 
     * @param itemDtos
     */
    public IncludedDto(List<ItemDto> itemDtos) {
        super();
        this.itemDtos = itemDtos;
    }

    @SerializedName("items")
    public List<ItemDto> getItems() {
        return itemDtos;
    }

    @SerializedName("items")
    public void setItems(List<ItemDto> itemDtos) {
        this.itemDtos = itemDtos;
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
