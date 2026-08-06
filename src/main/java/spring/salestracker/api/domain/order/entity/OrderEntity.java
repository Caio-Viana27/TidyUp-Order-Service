package spring.salestracker.api.domain.order.entity;

import org.springframework.data.annotation.Id;
import spring.salestracker.api.domain.customer.entity.CustomerEntity;
import spring.salestracker.api.domain.order.dto.OrderDTO;
import spring.salestracker.api.domain.order.model.OrderStatus;
import spring.salestracker.api.domain.product.entity.ProductEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderEntity {

    @Id
    private final String id;
    private CustomerEntity customer;
    private List<ProductEntity> products;
    private BigDecimal value;
    private OrderStatus status;
    private int paymentDay;
    private Timestamp createdAt;

    public OrderEntity(String id,
                       CustomerEntity customer,
                       List<ProductEntity> products,
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