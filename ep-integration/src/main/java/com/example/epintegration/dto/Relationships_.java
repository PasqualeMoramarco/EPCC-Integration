
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
    "cart_item"
})
public class Relationships_ {

    @SerializedName("cart_item")
    private CartItemDto cartItemDto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Relationships_() {
    }

    /**
     * 
     * @param cartItemDto
     */
    public Relationships_(CartItemDto cartItemDto) {
        super();
        this.cartItemDto = cartItemDto;
    }

    @SerializedName("cart_item")
    public CartItemDto getCartItem() {
        return cartItemDto;
    }

    @SerializedName("cart_item")
    public void setCartItem(CartItemDto cartItemDto) {
        this.cartItemDto = cartItemDto;
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
