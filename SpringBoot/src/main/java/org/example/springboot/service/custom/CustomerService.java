package org.example.springboot.service.custom;

import org.example.springboot.dto.CustomerDto;
import org.example.springboot.service.SuperBO;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService extends SuperBO {

    boolean saveCustomer(CustomerDto customerDto);
    ArrayList<CustomerDto> getCustomerList();
    boolean updateCustomer(CustomerDto customerDto);
    List<Long> getAllIds() ;
    String getCustomerName(String id);
    boolean deleteCustomer(String id);
}
