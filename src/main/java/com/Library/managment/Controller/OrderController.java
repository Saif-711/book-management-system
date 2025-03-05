package com.Library.managment.Controller;

import com.Library.managment.Model.Order;
import com.Library.managment.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/place-order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order1){
        orderService.placeOrder(order1);
        return new ResponseEntity<>(order1,HttpStatus.OK);
    }
    @GetMapping("/shpw-all-orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        orderService.viewAllOrders();
        return new ResponseEntity<>(orderService.viewAllOrders(),HttpStatus.OK);
    }


}
