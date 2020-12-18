package com.example.epintegration.service;

import com.example.epintegration.dto.OrderDto;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ElasticPathService {

    void updateOrder(OrderDto orderDto, String token) throws IOException, InterruptedException, URISyntaxException, JSONException;

}
