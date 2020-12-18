package com.example.epintegration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "status_erp")
    private String statusErp;

    @Column(name = "status")
    private String status;

    @Column(name = "payment")
    private String payment;

    @Column(name = "shipping")
    private String shipping;

    public Order() {
    }

    public Order(String orderId, String statusErp) {
        this.orderId = orderId;
        this.statusErp = statusErp;
    }

    public Order(String orderId, String statusErp, String status, String payment, String shipping) {
        this.orderId = orderId;
        this.statusErp = statusErp;
        this.status = status;
        this.payment = payment;
        this.shipping = shipping;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatusErp() {
        return statusErp;
    }

    public void setStatusErp(String statusErp) {
        this.statusErp = statusErp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }
}
