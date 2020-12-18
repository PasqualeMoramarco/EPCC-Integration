package com.example.epintegration.service;

import com.example.epintegration.dto.OrderDto;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface OrderService {

    void saveOrder(OrderDto orderDto);

    void updateOrder(OrderDto orderDto) throws IOException, InterruptedException, URISyntaxException, JSONException;

}
