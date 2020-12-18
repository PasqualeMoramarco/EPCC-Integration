package com.example.epintegration.service.web;

import com.example.epintegration.dto.DataDto;
import com.example.epintegration.dto.OrderDto;
import com.example.epintegration.service.OrderService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/order")
public class OrderWebService {
    private static final Logger logger = LoggerFactory.getLogger(OrderWebService.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/sendOrder")
    public ResponseEntity<OrderDto> sendOrder(@RequestBody String orderStr) throws JSONException, InterruptedException, IOException, URISyntaxException {
        logger.info("Received order - send to Erp");

        JSONObject orderObj = new JSONObject(orderStr);
        Gson gson = new GsonBuilder().create();
        OrderDto orderDto = gson.fromJson(orderObj.getJSONObject("payload").toString(), OrderDto.class);
        /** Salvo ordine sul database */
        orderService.saveOrder(orderDto);
        //TODO chiamata che invia l'ordine all'ERP
        /** Aggiorno lo stato dell'ordine su Elastic Path*/
        OrderDto orderDtoNew = new OrderDto();
        DataDto dataDto = new DataDto(orderDto.getData().getId(), "1 - Sent to Erp");
        orderDtoNew.setData(dataDto);
        orderService.updateOrder(orderDtoNew);

        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping("/updateStatusErp/{orderId}/status/{statusErp}")
    public ResponseEntity<OrderDto> updateStatusErp(@PathVariable String orderId,
                                                    @PathVariable String statusErp) throws IOException, InterruptedException, URISyntaxException, JSONException {
        logger.info("Update status Erp");

        OrderDto orderDto = new OrderDto();
        DataDto dataDto = new DataDto(orderId, statusErp);
        orderDto.setData(dataDto);
        /** Aggiorno lo statusErp dell'ordine sul database */
        orderService.updateOrder(orderDto);

        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
}
