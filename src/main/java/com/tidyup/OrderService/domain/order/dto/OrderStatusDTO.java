package com.tidyup.OrderService.domain.order.dto;

import com.tidyup.OrderService.domain.order.entity.OrderStatusEntity;
import com.tidyup.OrderService.domain.order.model.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderStatusDTO(
        @NotNull
        Long id,

        @NotNull
        OrderStatus status
) {
    public OrderStatusDTO(OrderStatusEntity orderStatus) {
        this(orderStatus.getId(), orderStatus.getStatus());
    }
}
