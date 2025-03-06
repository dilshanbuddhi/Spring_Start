package org.example.springboot.service.custom.IMPL;

import org.example.springboot.dto.ItemDTO;
import org.example.springboot.entity.Customer;
import org.example.springboot.entity.OrderDetail;
import org.example.springboot.entity.Orders;
import org.example.springboot.repo.CustomerRepo;
import org.example.springboot.repo.ItemRepo;
import org.example.springboot.repo.OrderRepo;
import org.example.springboot.repo.PlaceOrderRepo;
import org.example.springboot.service.custom.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

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
        return itemRepo.findAllId();
    }

    public ItemDTO getAllbyId(String id) {
        System.out.println("sss");
        return modelMapper.map(placeOrderRepo.getAllbyId(id), ItemDTO.class);
    }

    @Transactional
    public boolean placeOrder(long cid, ArrayList<ItemDTO> arrayList, double tot) {

        try {
            Optional<Customer> customer = customerRepo.findById(String.valueOf(cid));
            Orders orders = new Orders(tot, customer.get());
            orderRepo.save(orders);

            for (ItemDTO itemDTO : arrayList) {
                System.out.println(orders.getId()+ "   jjjjjjd");
                OrderDetail orderDetail = new OrderDetail(itemDTO.getQty() * itemDTO.getPrice(), itemDTO.getQty(), itemRepo.findById(itemDTO.getId()).get(), orders);
               placeOrderRepo.save(orderDetail);

                itemRepo.reduceQTY(itemDTO.getId(), itemDTO.getQty());
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            return false;
        }
        return true;

    }}


