package com.tidyup.OrderService.repository;

import com.tidyup.OrderService.domain.order.entity.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Long> {
}
