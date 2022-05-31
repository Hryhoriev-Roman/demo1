package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.converters.CustomerConverter;
import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerConverter converter;

    public CustomerService(CustomerRepo customerRepo, CustomerConverter converter) {
        this.customerRepo = customerRepo;
        this.converter = converter;
    }

    @Transactional
    public CustomerDto create(CustomerDto customerDto) {
        Customer customer = customerRepo.save(converter.toCustomer(customerDto));
        return converter.toDto(customerRepo.getById(customer.getId()));

    }
}
