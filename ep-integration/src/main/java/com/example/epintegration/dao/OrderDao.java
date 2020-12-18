package com.example.epintegration.dao;

import com.example.epintegration.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface OrderDao extends CrudRepository<Order, String> {

    @Transactional
    @Modifying
    @Query(value = "update ep_poc.orders set status_erp = ?2 where order_id = ?1 ", nativeQuery = true)
    void update(String orderId, String statusErp);
}
