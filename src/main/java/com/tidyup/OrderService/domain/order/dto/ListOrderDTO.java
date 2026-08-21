package com.tidyup.OrderService.domain.order.dto;

import com.tidyup.OrderService.domain.item.dto.ListItemDTO;
import com.tidyup.OrderService.domain.order.entity.OrderEntity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ListOrderDTO(
        @NotNull
        UUID id,

        @NotNull
        UUID retailerId,

        @NotNull
        UUID customerId,

        @NotNull
        LocalDateTime issuedAt,

        @NotNull
        OrderStatusDTO status,

        @NotNull
        List<ListItemDTO> items
) {
    public ListOrderDTO(OrderEntity order) {
        this(order.getId(),
                order.getRetailerId(),
                order.getCustomerId(),
                order.getIssuedAt(),
                new OrderStatusDTO(order.getStatus()),
                order.getItems().stream().map(ListItemDTO::new).toList()
        );
    }
}
