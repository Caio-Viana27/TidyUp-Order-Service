package com.tidyup.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tidyup.OrderService.domain.order.dto.CreateOrderDTO;
import com.tidyup.OrderService.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateOrderDTO> createOrder() {
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<CreateOrderDTO>> getAllOrders() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateOrderDTO> getOrderById(@PathVariable String orderId) {
        return ResponseEntity.ok().build();
    }
}