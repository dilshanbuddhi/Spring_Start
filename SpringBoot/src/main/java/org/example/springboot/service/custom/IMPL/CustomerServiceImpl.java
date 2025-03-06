package org.example.springboot.service.custom.IMPL;

import org.example.springboot.dto.CustomerDto;
import org.example.springboot.entity.Customer;
import org.example.springboot.repo.CustomerRepo;
import org.example.springboot.service.custom.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelmapper;



    public boolean saveCustomer(CustomerDto customerDto) {
        if (customerRepo.existsCustomxerByEmail(customerDto.getEmail())){
            throw new RuntimeException("Customer Not Found");
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
            throw new RuntimeException("Customer Not Found");
        }
    }


    private Set<SimpleGrantedAuthority> getAuthority(Customer user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getEmail()));
        return authorities;
    }

    public boolean updateCustomer(CustomerDto customerDto) {
        if (customerRepo.existsCustomerById(customerDto.getId())) {
            customerRepo.save(modelmapper.map(customerDto , Customer.class));
            return true;
        } else {
            throw new RuntimeException("Customer Not Found");
        }
    }

    public List<Long> getAllIds() {
        return customerRepo.findAllIds();
    }

    public String getCustomerName(String id) {
        return customerRepo.getCustomersById(id);
    }
}
