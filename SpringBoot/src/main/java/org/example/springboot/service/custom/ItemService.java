package org.example.springboot.service.custom;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.service.SuperBO;

import java.util.ArrayList;

public interface ItemService extends SuperBO {

    public boolean saveItem(ItemDTO dto) ;

    public ArrayList<ItemDTO> getItemList();

    public boolean deleteItem(String id);

    public boolean updateItem(ItemDTO dto) ;
    }
