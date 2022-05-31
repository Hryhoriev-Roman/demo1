package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private Long customerId;
    private String phone;
    private String email;
    private List<ProductDto> productDtoList;
}
