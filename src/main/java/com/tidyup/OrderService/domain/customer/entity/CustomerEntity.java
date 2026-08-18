package com.tidyup.OrderService.domain.customer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity {
    @Id
    private UUID id;
}