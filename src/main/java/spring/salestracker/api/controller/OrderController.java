package spring.salestracker.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.salestracker.api.domain.order.dto.OrderDTO;
import spring.salestracker.api.domain.order.model.OrderStatus;
import spring.salestracker.api.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
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
    public ResponseEntity<List<OrderDTO>> listAllOrders(@RequestParam(required = false) OrderStatus status) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<OrderDTO> listSpecificOrder(@PathVariable String orderId) {
        return ResponseEntity.ok().build();
    }
}