package com.example.epintegration.service;

import com.example.epintegration.dao.OrderDao;
import com.example.epintegration.dto.OrderDto;
import com.example.epintegration.mapper.OrderMapper;
import com.example.epintegration.model.Order;
import com.example.epintegration.utils.AuthorizationReq;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URISyntaxException;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private ElasticPathService elasticPathService;

    @Autowired
    private AuthorizationReq authorizationReq;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDao orderDao;

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Override
    public void saveOrder(OrderDto orderDto) {
        logger.info("Save order");
        Order order = orderMapper.orderDtoToOrder(orderDto);
        /** Salvo ordine sul db locale */
        orderDao.save(order);
    }

    @Override
    public void updateOrder(OrderDto orderDto) throws IOException, InterruptedException, URISyntaxException, JSONException {
        logger.info("Update order");
        /** Genero token di autenticazione */
        String token = authorizationReq.clientCredentialToken(clientId, clientSecret);
        /** Aggiorno lo statusErp dell'ordine su Elastic Path */
        elasticPathService.updateOrder(orderDto, token);
        /** Salvo ordine sul db locale */
        saveOrder(orderDto);
    }
}
