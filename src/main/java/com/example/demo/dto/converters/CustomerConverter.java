package com.example.demo.dto.converters;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerConverter {
    private final ProductConverter productConverter;

    public CustomerConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public Customer toCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getCustomerId());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setProducts(customerDto.getProductDtoList().stream().map(productConverter::toProduct).collect(Collectors.toList()));
        return customer;
    }

    public CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getId());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setProductDtoList(customer.getProducts().stream().map(productConverter::toDto).collect(Collectors.toList()));
        return customerDto;
    }
}
