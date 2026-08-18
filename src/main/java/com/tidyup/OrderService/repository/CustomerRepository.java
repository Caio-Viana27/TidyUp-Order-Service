package com.tidyup.OrderService.repository;

import com.tidyup.OrderService.domain.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

}