package org.example.springboot.service.custom;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.entity.Customer;
import org.example.springboot.entity.OrderDetail;
import org.example.springboot.entity.Orders;
import org.example.springboot.repo.CustomerRepo;
import org.example.springboot.repo.ItemRepo;
import org.example.springboot.repo.OrderRepo;
import org.example.springboot.repo.PlaceOrderRepo;
import org.example.springboot.service.SuperBO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface PlaceOrderService extends SuperBO {


    public List<Long> getAllItemIDs();

    public ItemDTO getAllbyId(String id);

    @Transactional
    public boolean placeOrder(long cid, ArrayList<ItemDTO> arrayList, double tot);
}


