package org.example.springboot.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.example.springboot.entity.Customer;

public class OrderDto {
    private long id;
    private double total;
    private CustomerDto customer;
}
