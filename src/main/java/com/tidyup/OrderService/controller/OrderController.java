package com.tidyup.OrderService.controller;

import com.tidyup.OrderService.domain.order.dto.CreatedOrderDTO;
import com.tidyup.OrderService.domain.order.dto.ListOrderDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tidyup.OrderService.domain.order.dto.CreateOrderDTO;
import com.tidyup.OrderService.service.OrderService;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${service.address}")
    private String RESOURCE_PATH;

    @PostMapping
    public ResponseEntity<CreatedOrderDTO> createOrder(@RequestBody @Valid CreateOrderDTO dto, UriComponentsBuilder uriBuilder) {
        CreatedOrderDTO createdOrder = orderService.create(dto);
        URI location = uriBuilder.path(RESOURCE_PATH + "/orders" + "/{id}").buildAndExpand(createdOrder.id()).toUri();
        return ResponseEntity.created(location).body(createdOrder);
    }

    @GetMapping
    public ResponseEntity<Page<ListOrderDTO>> getAllOrders(@PageableDefault(size = 20) Pageable pageable) {
        Page<ListOrderDTO> page = orderService.getAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListOrderDTO> getOrderById(@PathVariable UUID id) {
        ListOrderDTO orderDTO = orderService.getById(id);
        return ResponseEntity.ok(orderDTO);
    }
}