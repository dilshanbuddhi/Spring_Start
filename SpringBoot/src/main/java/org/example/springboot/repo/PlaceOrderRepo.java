package org.example.springboot.repo;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.entity.Item;
import org.example.springboot.entity.OrderDetail;
import org.example.springboot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaceOrderRepo extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select * from item where id = :id", nativeQuery = true)
    Item getAllbyId(String id);
}
