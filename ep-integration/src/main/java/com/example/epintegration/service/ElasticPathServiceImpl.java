package com.example.epintegration.service;

import com.example.epintegration.dto.OrderDto;
import com.example.epintegration.utils.HttpReq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.http.HttpResponse;

public class ElasticPathServiceImpl implements ElasticPathService {
    private static final Logger logger = LoggerFactory.getLogger(ElasticPathServiceImpl.class);

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private HttpReq httpReq;

    @Override
    public void updateOrder(OrderDto orderDto, String token) throws IOException, InterruptedException, JSONException {
        logger.info("Update order %s", orderDto.getData().getId());
        String url = baseUrl.concat("/orders/").concat(orderDto.getData().getId());
        orderDto.getData().setType("order");
        HttpResponse<String> response = httpReq.httpPut(orderDto, url, token);

        JSONObject orderObj = new JSONObject(response.body());
        Gson gson = new GsonBuilder().create();
        orderDto.setData(gson.fromJson(orderObj.toString(), OrderDto.class).getData());
    }
}
