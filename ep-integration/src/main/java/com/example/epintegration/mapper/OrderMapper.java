package com.example.epintegration.mapper;

import com.example.epintegration.dto.OrderDto;
import com.example.epintegration.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "orderDto.data.id", target = "orderId"),
            @Mapping(source = "orderDto.data.statusErp", target = "statusErp"),
            @Mapping(source = "orderDto.data.status", target = "status"),
            @Mapping(source = "orderDto.data.payment", target = "payment"),
            @Mapping(source = "orderDto.data.shipping", target = "shipping")
    })
    Order orderDtoToOrder(OrderDto orderDto);
}
