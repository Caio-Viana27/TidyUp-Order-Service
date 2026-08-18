package com.tidyup.OrderService.domain.item.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    private UUID id;
}
