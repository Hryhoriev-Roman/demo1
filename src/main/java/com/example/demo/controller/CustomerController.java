package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    private final ProductService productService;

    public CustomerController(CustomerService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }

    @PostMapping
    public CustomerDto create(@RequestBody CustomerDto customerDto){
        return service.create(customerDto);
    }

}
