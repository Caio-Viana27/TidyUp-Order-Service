package com.tidyup.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.tidyup.OrderService.service.CustomerService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;
}