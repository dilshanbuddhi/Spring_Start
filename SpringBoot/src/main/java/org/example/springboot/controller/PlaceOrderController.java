package org.example.springboot.controller;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.dto.OrderDetailDTO;
import org.example.springboot.service.custom.IMPL.CustomerServiceImpl;
import org.example.springboot.service.custom.IMPL.PlaceOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/placeOrder")
public class PlaceOrderController {

@Autowired
private PlaceOrderServiceImpl placeOrderService;

@Autowired
private CustomerServiceImpl customerService;

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
    public ResponseEntity saveOrder(@RequestBody OrderDetailDTO dto){
        try {
            System.out.println(dto.getCid()+" "+dto.getArrayList());

            for (ItemDTO itemDTO : dto.getArrayList()) {
                System.out.println(itemDTO.getId() + "  " + itemDTO.getQty()+" "+itemDTO.getPrice());
                System.out.println("Item Total : "+itemDTO.getQty()*itemDTO.getPrice());
                System.out.println("Full Total :" + dto.getTot());

            }
            boolean result = placeOrderService.placeOrder(dto.getCid(),dto.getArrayList(),dto.getTot());
            if (result) {
                return new ResponseEntity("Order Saved Successfully!!!", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity("Order Saved Unsuccessfully!!!!!!",HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
