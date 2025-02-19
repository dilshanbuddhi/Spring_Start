package org.example.springboot.service;

import org.example.springboot.dto.CustomerDto;
import org.example.springboot.dto.ItemDTO;
import org.example.springboot.entity.Customer;
import org.example.springboot.entity.Item;
import org.example.springboot.repo.CustomerRepo;
import org.example.springboot.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {


    @Autowired
    private ModelMapper modelmapper;
    @Autowired
    private ItemRepo itemRepo;

    public boolean saveItem(ItemDTO dto) {
        if (itemRepo.existsById(Long.valueOf(dto.getId()))){
            return false;
        }
        itemRepo.save(modelmapper.map(dto , Item.class));
        return true;
    }

    public ArrayList<ItemDTO> getItemList() {
        ArrayList<Item> customerList = (ArrayList<Item>) itemRepo.findAll();
        ArrayList<ItemDTO> customerDtoList = new ArrayList<>();
        for (Item customer : customerList) {
            customerDtoList.add(modelmapper.map(customer , ItemDTO.class));
        }
        return customerDtoList;
    }

    public boolean deleteItem(String id) {
        if (itemRepo.existsById(Long.valueOf(id))) {
            itemRepo.deleteById(Long.valueOf(id));
            return true;
        } else {
            return false;
        }
    }

    public boolean updateItem(ItemDTO dto) {
        if (itemRepo.existsById(Long.valueOf(dto.getId()))) {
            itemRepo.save(modelmapper.map(dto , Item.class));
            return true;
        } else {
            return false;
        }
    }
}
