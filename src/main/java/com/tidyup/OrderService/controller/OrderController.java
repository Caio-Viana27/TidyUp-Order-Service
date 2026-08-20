package com.tidyup.OrderService.controller;

import com.tidyup.OrderService.domain.order.dto.CreatedOrderDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tidyup.OrderService.domain.order.dto.CreateOrderDTO;
import com.tidyup.OrderService.service.OrderService;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${resource.path}")
    private String RESOURCE_PATH;

    @PostMapping
    public ResponseEntity<CreatedOrderDTO> createOrder(@RequestBody @Valid CreateOrderDTO dto, UriComponentsBuilder uriBuilder) {
        CreatedOrderDTO createdOrder = orderService.create(dto);
        URI location = uriBuilder.path(RESOURCE_PATH + "/orders" + "/{id}").buildAndExpand(createdOrder.id()).toUri();
        return ResponseEntity.created(location).body(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<CreateOrderDTO>> getAllOrders(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateOrderDTO> getOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }
}