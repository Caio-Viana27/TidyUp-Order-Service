package com.tidyup.OrderService.domain.order.dto;

import com.tidyup.OrderService.domain.item.dto.ItemDTO;
import com.tidyup.OrderService.domain.order.entity.OrderEntity;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreatedOrderDTO(
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
        List<ItemDTO> items,

        @NotNull
        LocalDateTime createdAt
) {
    public CreatedOrderDTO(OrderEntity order) {
        this(order.getId(),
                order.getRetailerId(),
                order.getCustomerId(),
                order.getIssuedAt(),
                new OrderStatusDTO(order.getStatus()),
                order.getItems().stream().map(ItemDTO::new).toList(),
                order.getCreatedAt()
        );
    }
}
