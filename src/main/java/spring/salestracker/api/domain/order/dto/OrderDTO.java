package spring.salestracker.api.domain.order.dto;


import spring.salestracker.api.domain.customer.entity.CustomerEntity;
import spring.salestracker.api.domain.order.model.OrderStatus;
import spring.salestracker.api.domain.product.entity.ProductEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public record OrderDTO (String id,
                        CustomerEntity customer,
                        List<ProductEntity> products,
                        BigDecimal value,
                        OrderStatus status,
                        int paymentDay,
                        Timestamp createdAt) {
}