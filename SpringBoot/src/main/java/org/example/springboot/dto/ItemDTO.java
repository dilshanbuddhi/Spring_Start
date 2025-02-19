package org.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {
    private long id;
    private String name;
    private String des;
    private int qty;
    private double price;

    public ItemDTO(long id, int qty, double price) {
        this.id = id;
        this.qty = qty;
        this.price = price;
    }
}
