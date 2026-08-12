package com.tidyup.OrderService.domain.order.dto;


import com.tidyup.OrderService.domain.customer.entity.CustomerEntity;
import com.tidyup.OrderService.domain.order.model.OrderStatus;
import com.tidyup.OrderService.domain.item.entity.Item;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public record OrderDTO (String id,
                        CustomerEntity customer,
                        List<Item> products,
                        BigDecimal value,
                        OrderStatus status,
                        int paymentDay,
                        Timestamp createdAt) {
}