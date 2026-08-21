package com.tidyup.OrderService.domain.item.entity;

import com.tidyup.OrderService.domain.item.dto.ItemDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEMS")
public class ItemEntity {
    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "PRODUCT_ID")
    private UUID productId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SKU")
    private String SKU;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @Column(name = "TOTAL_DISCOUNT")
    private BigDecimal totalDiscount;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public ItemEntity(ItemDTO dto) {
        this.id = UUID.randomUUID();
        this.productId = dto.productId();
        this.quantity = dto.quantity();
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }
}