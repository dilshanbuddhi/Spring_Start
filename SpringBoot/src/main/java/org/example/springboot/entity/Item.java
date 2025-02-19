package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String des;
    private int qty;
    private double price;

    @OneToMany(mappedBy = "item")
    private List<OrderDetail> ordersList;

    public Item(long id, String name, String des, int qty, double price) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.qty = qty;
        this.price = price;
    }
}
