package org.example.springboot.service;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.entity.Customer;
import org.example.springboot.entity.Item;
import org.example.springboot.entity.OrderDetail;
import org.example.springboot.entity.Orders;
import org.example.springboot.repo.CustomerRepo;
import org.example.springboot.repo.ItemRepo;
import org.example.springboot.repo.OrderRepo;
import org.example.springboot.repo.PlaceOrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceOrderService {

    @Autowired
    private PlaceOrderRepo placeOrderRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    ModelMapper modelMapper;


    public List<Long> getAllItemIDs() {
        return itemRepo.findAllIds();
    }

    public ItemDTO getAllbyId(String id) {
        System.out.println("sss");
        return modelMapper.map(placeOrderRepo.getAllbyId(id), ItemDTO.class);
    }

    @Transactional
    public void placeOrder(long cid, ArrayList<ItemDTO> arrayList, double tot) {
        Optional<Customer> customer = customerRepo.findById(String.valueOf(cid));
        Orders orders = new Orders(tot, customer.get());
        orderRepo.save(orders);

        for (ItemDTO itemDTO : arrayList) {
            OrderDetail orderDetail = new OrderDetail(orders.getId(),orders,itemRepo.findById(itemDTO.getId()).get(), itemDTO.getQty(), itemDTO.getQty() * itemDTO.getPrice());
            placeOrderRepo.save(orderDetail);

            itemRepo.reduceQTY(itemDTO.getId(), itemDTO.getQty());
        }

}}


