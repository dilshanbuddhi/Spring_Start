package org.example.springboot.repo;

import org.example.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    boolean existsCustomxerByEmail(String email);

    boolean existsCustomerById(String id);

    @Query(value = "select id from customer", nativeQuery = true)
    List<Long> findAllIds();

    @Query(value = "select name from customer where id = :id", nativeQuery = true)
    String getCustomersById(String id);
}
