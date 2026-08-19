package com.tidyup.OrderService.domain.order.dto;

import com.tidyup.OrderService.domain.item.entity.ItemEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CreateOrderDTO(
        UUID retailerId,
        UUID customerId,
        Integer totalItems,
        List<ItemEntity> items,
        BigDecimal value
) {

}