package com.tidyup.OrderService.domain.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.tidyup.OrderService.domain.customer.entity.CustomerEntity;
import com.tidyup.OrderService.domain.order.dto.OrderDTO;
import com.tidyup.OrderService.domain.order.model.OrderStatus;
import com.tidyup.OrderService.domain.item.entity.Item;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    private UUID id;
    private CustomerEntity customer;
    private List<Item> products;
    private BigDecimal value;
    private OrderStatus status;
    private int paymentDay;
    private Timestamp createdAt;

    public OrderEntity(UUID id,
                       CustomerEntity customer,
                       List<Item> products,
                       BigDecimal value,
                       OrderStatus status,
                       int paymentDay,
                       Timestamp createdAt) {

        this.id = id;
        this.customer = customer;
        this.value = value;
        this.products = products;
        this.status = status;
        this.paymentDay = paymentDay;
        this.createdAt = createdAt;
    }

    public OrderEntity(OrderDTO dto) {
        this.id = dto.id();
        this.customer = dto.customer();
        this.products = dto.products();
        this.value = dto.value();
        this.status = dto.status();
        this.paymentDay = dto.paymentDay();
        this.createdAt = dto.createdAt();
    }

    public OrderDTO dto() {
        return new OrderDTO(this.id, this.customer, this.products, this.value, this.status, this.paymentDay, this.createdAt);
    }
}