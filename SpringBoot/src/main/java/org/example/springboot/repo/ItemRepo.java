package org.example.springboot.repo;

import org.example.springboot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {

    @Query(
            value = "select id from item",
            nativeQuery = true
    )
    List<Long> findAllIds();


    @Modifying
    @Query(
            value = "update item set qty = qty - ?2 where id = ?1",
            nativeQuery = true
    )
    void reduceQTY(long id, int qty);
}
