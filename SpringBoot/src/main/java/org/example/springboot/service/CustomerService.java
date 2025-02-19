package org.example.springboot.service;

import org.example.springboot.dto.CustomerDto;
import org.example.springboot.entity.Customer;
import org.example.springboot.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.getType;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelmapper;

    public boolean saveCustomer(CustomerDto customerDto) {
        if (customerRepo.existsCustomxerByEmail(customerDto.getEmail())){
            return false;
        }
        customerRepo.save(modelmapper.map(customerDto , Customer.class));
        return true;
    }

    public ArrayList<CustomerDto> getCustomerList() {
       return modelmapper.map(customerRepo.findAll() , new TypeToken<List<CustomerDto>>(){}.getType());
    }

    public boolean deleteCustomer(String id) {
        if (customerRepo.existsCustomerById(id)) {
            customerRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateCustomer(CustomerDto customerDto) {
        if (customerRepo.existsCustomerById(customerDto.getId())) {
            customerRepo.save(modelmapper.map(customerDto , Customer.class));
            return true;
        } else {
            return false;
        }
    }

    public List<Long> getAllIds() {
        return customerRepo.findAllIds();
    }

    public String getCustomerName(String id) {
        return customerRepo.getCustomersById(id);
    }
}
