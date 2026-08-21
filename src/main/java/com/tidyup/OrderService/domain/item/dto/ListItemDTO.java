package com.tidyup.OrderService.domain.item.dto;

import com.tidyup.OrderService.domain.item.entity.ItemEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record ListItemDTO(
        @NotNull
        UUID id,

        @NotNull
        UUID productId,

        @NotBlank
        @Size(max = 50)
        String name,

        @NotBlank
        @Size(max = 20)
        String SKU,

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
    public ListItemDTO(ItemEntity item) {
        this(item.getId(), item.getProductId(), item.getName(), item.getSKU(), item.getQuantity(), item.getUnitPrice(), item.getTotalDiscount());
    }
}