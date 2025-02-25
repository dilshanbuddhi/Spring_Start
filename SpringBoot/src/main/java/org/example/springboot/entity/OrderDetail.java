package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Item item;
    private int qty;
    private double total;

    public OrderDetail(double total, int qty, Item item, Orders orders) {
        this.total = total;
        this.qty = qty;
        this.item = item;
        this.orders = orders;
    }
}
