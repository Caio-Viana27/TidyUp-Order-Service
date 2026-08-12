package com.tidyup.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.tidyup.OrderService.service.CustomerService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }
}