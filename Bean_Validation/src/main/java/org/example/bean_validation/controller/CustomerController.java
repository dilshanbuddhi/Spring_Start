package org.example.bean_validation.controller;

import jakarta.validation.Valid;
import org.example.bean_validation.Dro.CustomerDto;
import org.example.bean_validation.Dro.ResponceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @PostMapping("/post")
    public ResponseEntity<ResponceDto> getCustomer(@Valid @RequestBody CustomerDto customer) {
        return new ResponseEntity<>(
                new ResponceDto(
                        201,
                        "success",
                        customer)
                , HttpStatus.OK);
    }
}
