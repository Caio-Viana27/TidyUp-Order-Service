package com.tidyup.OrderService.repository;


import com.tidyup.OrderService.domain.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

}