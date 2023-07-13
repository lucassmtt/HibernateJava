package com.FirstProjectWithSpring.resources;

import com.FirstProjectWithSpring.entities.Order;
import com.FirstProjectWithSpring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<Order> findById(@PathVariable Long Id) {
        Order order = orderService.findById(Id);
        return ResponseEntity.ok().body(order);
    }
}
