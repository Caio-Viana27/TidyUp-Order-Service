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

    @Column(name = "TOTAL_ITEMS")
    private Integer totalItems;

    @OneToMany
    private List<ItemEntity> items;

    @Column(name = "TOTAL_VALUE")
    private BigDecimal totalValue;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;

    public OrderEntity(CreateOrderDTO dto) {}
}