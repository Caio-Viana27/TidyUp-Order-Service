package com.tidyup.OrderService.domain.item.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemDTO (
        @NotNull
        UUID id,

        @NotNull
        UUID productId,

        @NotNull
        @PositiveOrZero
        Integer quantity,

        @NotNull
        @PositiveOrZero
        BigDecimal unitPrice,

        @NotNull
        @PositiveOrZero
        BigDecimal totalDiscount
) {
}
