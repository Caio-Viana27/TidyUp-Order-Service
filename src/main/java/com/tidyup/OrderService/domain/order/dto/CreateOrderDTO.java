package com.tidyup.OrderService.domain.order.dto;

import com.tidyup.OrderService.domain.item.dto.ItemDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record CreateOrderDTO(
        @NotNull
        UUID retailerId,

        @NotNull
        UUID customerId,

        @NotNull
        List<ItemDTO> items
) {}