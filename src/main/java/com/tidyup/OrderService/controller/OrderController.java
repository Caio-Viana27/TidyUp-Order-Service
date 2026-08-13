package com.tidyup.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tidyup.OrderService.domain.order.dto.OrderDTO;
import com.tidyup.OrderService.domain.order.model.OrderStatus;
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
    public ResponseEntity<OrderDTO> createOrder() {
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(@RequestParam(required = false) OrderStatus status) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable String orderId) {
        return ResponseEntity.ok().build();
    }
}