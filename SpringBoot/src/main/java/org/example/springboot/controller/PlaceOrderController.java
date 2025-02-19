package org.example.springboot.controller;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.dto.OrderDetailDTO;
import org.example.springboot.service.CustomerService;
import org.example.springboot.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/placeOrder")
public class PlaceOrderController {

@Autowired
private PlaceOrderService placeOrderService;

@Autowired
private CustomerService customerService;

@GetMapping("/getCIDs")
public List<Long> getCustomerIDs(){
    return customerService.getAllIds();

}

@GetMapping("/getAllItemIDs")
    public List<Long> getAllItemIDs(){
        return placeOrderService.getAllItemIDs();
    }

    @GetMapping("/getAllbyId/{id}")
    public ItemDTO getAllbyId(@PathVariable String id){
        return placeOrderService.getAllbyId(id);

    }

    @PostMapping("/save")
    public boolean saveOrder(@RequestBody OrderDetailDTO dto){
        System.out.println(dto.getCid()+" "+dto.getArrayList());

        for (ItemDTO itemDTO : dto.getArrayList()) {
            System.out.println(itemDTO.getId() + "  " + itemDTO.getQty()+" "+itemDTO.getPrice());
            System.out.println("Item Total : "+itemDTO.getQty()*itemDTO.getPrice());
            System.out.println("Full Total :" + dto.getTot());

        }
        placeOrderService.placeOrder(dto.getCid(),dto.getArrayList(),dto.getTot());

        return true;

    }
}
