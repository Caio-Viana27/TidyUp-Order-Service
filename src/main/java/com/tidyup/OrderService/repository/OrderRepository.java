package com.tidyup.OrderService.repository;

import com.tidyup.OrderService.domain.order.entity.OrderEntity;
import com.tidyup.OrderService.domain.order.entity.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    Optional<OrderStatusEntity> findByStatus(String status);
}