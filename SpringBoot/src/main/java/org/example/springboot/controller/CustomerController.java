package org.example.springboot.controller;

import org.example.springboot.dto.CustomerDto;
import org.example.springboot.service.ServiceFactory;
import org.example.springboot.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService = (CustomerService) ServiceFactory.getBoFactory().getBO(ServiceFactory.BOTypes.CUSTOMER);

    @PostMapping("/save")
    public ResponseEntity<Object> saveCustomer(@RequestBody CustomerDto customerDto){
      try {
          System.out.println(customerDto.getEmail()+" "+customerDto.getName());
          boolean result = customerService.saveCustomer(customerDto);

          if (result) {
              return new ResponseEntity(" Customer Saved Successfully!!!",HttpStatus.ACCEPTED);
          }else {
              return new ResponseEntity("Customer Saved Unsuccessfully!!!!!!",HttpStatus.BAD_REQUEST);
          }

      } catch (Exception e) {
          return ResponseEntity.badRequest().body(e.getMessage());
      }


    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getCustomer(){
        try {
            ArrayList<CustomerDto> customerDtoList = customerService.getCustomerList();

            if (customerDtoList.isEmpty()) {
                return new ResponseEntity("List Not Found",HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity(customerDtoList,HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String id){
        try {
            boolean result = customerService.deleteCustomer(id);

            if (result) {
                return new ResponseEntity("Customer Deleted Successfully!!!", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity("Customer Deleted Unsuccessfully!!!!!!",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateCustomer(@RequestBody CustomerDto customerDto){
        try {
            System.out.println(customerDto.getEmail()+" "+customerDto.getName());
            boolean result = customerService.updateCustomer(customerDto);

            if (result) {
                return new ResponseEntity("Customer Update Successfully!!!", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity("Customer Update Unsuccessfully!!!!!!",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getCName/{id}")
    public String getCustomerName(@PathVariable String id){
        try {
            return customerService.getCustomerName(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
