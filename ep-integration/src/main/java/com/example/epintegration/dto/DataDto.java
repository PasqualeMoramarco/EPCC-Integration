
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
    "id",
    "type",
    "status_erp",
    "status",
    "payment",
    "shipping",
    "customer",
    "shipping_address",
    "billing_address",
    "links",
    "meta",
    "relationships"
})
public class DataDto {

    @SerializedName("id")
    private String id;
    @SerializedName("type")
    private String type;
    @SerializedName("status_erp")
    private String statusErp;
    @SerializedName("status")
    private String status;
    @SerializedName("payment")
    private String payment;
    @SerializedName("shipping")
    private String shipping;
    @SerializedName("customer")
    private CustomerDto customerDto;
    @SerializedName("shipping_address")
    private ShippingAddressDto shippingAddressDto;
    @SerializedName("billing_address")
    private BillingAddressDto billingAddressDto;
    @SerializedName("links")
    private LinksDto linksDto;
    @SerializedName("meta")
    private MetaDto metaDto;
    @SerializedName("relationships")
    private RelationshipsDto relationshipsDto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataDto() {
    }

    public DataDto(String id, String statusErp) {
        this.id = id;
        this.statusErp = statusErp;
    }

    /**
     * 
     * @param relationshipsDto
     * @param shipping
     * @param metaDto
     * @param shippingAddressDto
     * @param payment
     * @param linksDto
     * @param id
     * @param statusErp
     * @param billingAddressDto
     * @param type
     * @param status
     * @param customerDto
     */
    public DataDto(String id, String type, String statusErp, String status, String payment, String shipping, CustomerDto customerDto, ShippingAddressDto shippingAddressDto, BillingAddressDto billingAddressDto, LinksDto linksDto, MetaDto metaDto, RelationshipsDto relationshipsDto) {
        super();
        this.id = id;
        this.type = type;
        this.statusErp = statusErp;
        this.status = status;
        this.payment = payment;
        this.shipping = shipping;
        this.customerDto = customerDto;
        this.shippingAddressDto = shippingAddressDto;
        this.billingAddressDto = billingAddressDto;
        this.linksDto = linksDto;
        this.metaDto = metaDto;
        this.relationshipsDto = relationshipsDto;
    }

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("type")
    public String getType() {
        return type;
    }

    @SerializedName("type")
    public void setType(String type) {
        this.type = type;
    }

    @SerializedName("status_erp")
    public String getStatusErp() {
        return statusErp;
    }

    @SerializedName("status_erp")
    public void setStatusErp(String statusErp) {
        this.statusErp = statusErp;
    }

    @SerializedName("status")
    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("payment")
    public String getPayment() {
        return payment;
    }

    @SerializedName("payment")
    public void setPayment(String payment) {
        this.payment = payment;
    }

    @SerializedName("shipping")
    public String getShipping() {
        return shipping;
    }

    @SerializedName("shipping")
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    @SerializedName("customer")
    public CustomerDto getCustomer() {
        return customerDto;
    }

    @SerializedName("customer")
    public void setCustomer(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    @SerializedName("shipping_address")
    public ShippingAddressDto getShippingAddress() {
        return shippingAddressDto;
    }

    @SerializedName("shipping_address")
    public void setShippingAddress(ShippingAddressDto shippingAddressDto) {
        this.shippingAddressDto = shippingAddressDto;
    }

    @SerializedName("billing_address")
    public BillingAddressDto getBillingAddress() {
        return billingAddressDto;
    }

    @SerializedName("billing_address")
    public void setBillingAddress(BillingAddressDto billingAddressDto) {
        this.billingAddressDto = billingAddressDto;
    }

    @SerializedName("links")
    public LinksDto getLinks() {
        return linksDto;
    }

    @SerializedName("links")
    public void setLinks(LinksDto linksDto) {
        this.linksDto = linksDto;
    }

    @SerializedName("meta")
    public MetaDto getMeta() {
        return metaDto;
    }

    @SerializedName("meta")
    public void setMeta(MetaDto metaDto) {
        this.metaDto = metaDto;
    }

    @SerializedName("relationships")
    public RelationshipsDto getRelationships() {
        return relationshipsDto;
    }

    @SerializedName("relationships")
    public void setRelationships(RelationshipsDto relationshipsDto) {
        this.relationshipsDto = relationshipsDto;
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
