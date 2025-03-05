package com.Library.managment.Service;

import com.Library.managment.Model.Order;
import com.Library.managment.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    public void placeOrder(Order order){
        Order orderPlaced=orderRepo.save(order);
    }
    public List<Order> viewAllOrders(){
       return orderRepo.findAll();
    }

}
