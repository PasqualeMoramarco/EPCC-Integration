
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
    "items"
})
public class RelationshipsDto {

    @SerializedName("items")
    private ItemsDto itemsDto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RelationshipsDto() {
    }

    /**
     * 
     * @param itemsDto
     */
    public RelationshipsDto(ItemsDto itemsDto) {
        super();
        this.itemsDto = itemsDto;
    }

    @SerializedName("items")
    public ItemsDto getItems() {
        return itemsDto;
    }

    @SerializedName("items")
    public void setItems(ItemsDto itemsDto) {
        this.itemsDto = itemsDto;
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
