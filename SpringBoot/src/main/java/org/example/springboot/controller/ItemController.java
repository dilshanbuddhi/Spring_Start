package org.example.springboot.controller;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.service.custom.IMPL.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/item")
/*
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
*/
/*
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
*/

@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveItem(@RequestBody ItemDTO itemdto){
        try {
            boolean result = itemService.saveItem(itemdto);

            if (result) {
                return new ResponseEntity("Item Saved Successfully!!!", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity("Item Saved Unsuccessfully!!!!!!",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getCustomer(){
        try {
            ArrayList<ItemDTO> customerDtoList = itemService.getItemList();

            if (customerDtoList.isEmpty()) {
                return new ResponseEntity("List Not Found",HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity(customerDtoList,HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String id){
        try {
            boolean result = itemService.deleteItem(id);

            if (result) {
                return new ResponseEntity("Item Deleted Successfully!!!", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity("Item Deleted Unsuccessfully!!!!!!",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateCustomer(@RequestBody ItemDTO itemdto){
        try {
            boolean result = itemService.updateItem(itemdto);

            if (result) {
                return new ResponseEntity("Item Update Successfully!!!", HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity("Item Update Unsuccessfully!!!!!!",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
