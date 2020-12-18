
package com.example.epintegration.dto;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "id",
        "quantity",
        "product_id",
        "name",
        "sku",
        "unit_price",
        "value",
        "links",
        "meta",
        "relationships"
})
public class ItemDto {

    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("quantity")
    private Integer quantity;
    @SerializedName("product_id")
    private String productId;
    @SerializedName("name")
    private String name;
    @SerializedName("sku")
    private String sku;
    @SerializedName("unit_price")
    private UnitPriceDto unitPriceDto;
    @SerializedName("value")
    private ValueDto valueDto;
    @SerializedName("links")
    private Links_ links;
    @SerializedName("meta")
    private Meta_ meta;
    @SerializedName("relationships")
    private Relationships_ relationships;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ItemDto() {
    }

    /**
     * @param unitPriceDto
     * @param relationships
     * @param quantity
     * @param productId
     * @param meta
     * @param name
     * @param links
     * @param id
     * @param type
     * @param sku
     * @param valueDto
     */
    public ItemDto(String type, String id, Integer quantity, String productId, String name, String sku, UnitPriceDto unitPriceDto, ValueDto valueDto, Links_ links, Meta_ meta, Relationships_ relationships) {
        super();
        this.type = type;
        this.id = id;
        this.quantity = quantity;
        this.productId = productId;
        this.name = name;
        this.sku = sku;
        this.unitPriceDto = unitPriceDto;
        this.valueDto = valueDto;
        this.links = links;
        this.meta = meta;
        this.relationships = relationships;
    }

    @SerializedName("type")
    public String getType() {
        return type;
    }

    @SerializedName("type")
    public void setType(String type) {
        this.type = type;
    }

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @SerializedName("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @SerializedName("product_id")
    public String getProductId() {
        return productId;
    }

    @SerializedName("product_id")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("sku")
    public String getSku() {
        return sku;
    }

    @SerializedName("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    @SerializedName("unit_price")
    public UnitPriceDto getUnitPrice() {
        return unitPriceDto;
    }

    @SerializedName("unit_price")
    public void setUnitPrice(UnitPriceDto unitPriceDto) {
        this.unitPriceDto = unitPriceDto;
    }

    @SerializedName("value")
    public ValueDto getValue() {
        return valueDto;
    }

    @SerializedName("value")
    public void setValue(ValueDto valueDto) {
        this.valueDto = valueDto;
    }

    @SerializedName("links")
    public Links_ getLinks() {
        return links;
    }

    @SerializedName("links")
    public void setLinks(Links_ links) {
        this.links = links;
    }

    @SerializedName("meta")
    public Meta_ getMeta() {
        return meta;
    }

    @SerializedName("meta")
    public void setMeta(Meta_ meta) {
        this.meta = meta;
    }

    @SerializedName("relationships")
    public Relationships_ getRelationships() {
        return relationships;
    }

    @SerializedName("relationships")
    public void setRelationships(Relationships_ relationships) {
        this.relationships = relationships;
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
