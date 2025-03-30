package com.platzi.platzi_api_jpa.web.controller;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaOrderEntity;
import com.platzi.platzi_api_jpa.service.PizzaOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaOrderEntity>> getAll(){
        return ResponseEntity.ok(pizzaOrderService.getAll());
    }

    @GetMapping("/after")
    public ResponseEntity<List<PizzaOrderEntity>> getAllAfterDate(){
        return ResponseEntity.ok(pizzaOrderService.getAllAfterDate());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<PizzaOrderEntity>> getOutsideOrders(){
        return ResponseEntity.ok(pizzaOrderService.getOutsideOrders());
    }

    @GetMapping("/customer_orders/{id_customer}")
    public ResponseEntity<List<PizzaOrderEntity>> findCustomerOrders(@PathVariable String id_customer){
        return ResponseEntity.ok(pizzaOrderService.findCustomerOrders(id_customer));
    }


}
