package com.tidyup.OrderService.domain.order.entity;

import jakarta.persistence.*;
import com.tidyup.OrderService.domain.order.dto.CreateOrderDTO;
import com.tidyup.OrderService.domain.item.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class OrderEntity {
    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "RETAILER_ID")
    private UUID retailerId;

    @Column(name = "CUSTOMER_ID")
    private UUID customerId;

    @Column(name = "ISSUED_AT")
    private LocalDateTime issuedAt;

    @ManyToOne
    private OrderStatusEntity status;

    @OneToMany
    private List<ItemEntity> items;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;

    public OrderEntity(UUID retailerId, UUID customerId, List<ItemEntity> itemEntityList) {
        this.id = UUID.randomUUID();
        this.retailerId = retailerId;
        this.customerId = customerId;
        this.issuedAt = this.createdAt = this.updatedAt = LocalDateTime.now();
        this.items = itemEntityList;
    }

    public BigDecimal getOrderValue(List<ItemEntity> itemEntityList) {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (var item : itemEntityList) {
            BigDecimal unitPrice = item.getUnitPrice();
            BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());
            totalValue = totalValue.add(unitPrice.multiply(quantity));
        }
        return totalValue;
    }
}