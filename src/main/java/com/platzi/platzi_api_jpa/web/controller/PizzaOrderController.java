package com.platzi.platzi_api_jpa.web.controller;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaOrderEntity;
import com.platzi.platzi_api_jpa.persistence.proyection.OrderSummary;
import com.platzi.platzi_api_jpa.service.PizzaOrderService;
import com.platzi.platzi_api_jpa.service.dto.RandomOrderDto;
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

    @GetMapping("/order_summary/{order_id}")
    public ResponseEntity<OrderSummary> getSummary(@PathVariable int order_id){
        return ResponseEntity.ok(pizzaOrderService.getSummary(order_id));
    }

    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto) {
        return ResponseEntity.ok(this.pizzaOrderService.saveRandomOrder(dto));
    }

}
