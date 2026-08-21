package com.tidyup.OrderService.domain.item.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

public record ItemDTO (
        @NotNull
        UUID productId,

        @NotNull
        @PositiveOrZero
        Integer quantity
) {}
