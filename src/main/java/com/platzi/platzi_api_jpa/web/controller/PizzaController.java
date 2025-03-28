package com.platzi.platzi_api_jpa.web.controller;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaEntity;
import com.platzi.platzi_api_jpa.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAvailable(){
        return ResponseEntity.ok((pizzaService.getAvailable()));
    }

    @GetMapping("/with/{description}")
    public ResponseEntity<List<PizzaEntity>> getWithDescription(@PathVariable String description){
        return ResponseEntity.ok(pizzaService.getWithDescription(description));
    }

    @GetMapping("/without/{description}")
    public ResponseEntity<List<PizzaEntity>> getWithoutDescription(@PathVariable String description){
        return ResponseEntity.ok(pizzaService.getWithoutDescription(description));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable int id){
        return ResponseEntity.ok(pizzaService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(pizzaService.getByName(name));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<PizzaEntity>> getByPrice(@PathVariable double price){
        return ResponseEntity.ok((pizzaService.getByPrice(price)));
    }

    @PostMapping("/")
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizzaEntity){

        if(pizzaEntity.getIdPizza() == null || pizzaService.existsById(pizzaEntity.getIdPizza())){
            return ResponseEntity.ok(pizzaService.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/")
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizzaEntity){
        if(pizzaEntity.getIdPizza() != null && pizzaService.existsById(pizzaEntity.getIdPizza())){
            return ResponseEntity.ok(pizzaService.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(pizzaService.existsById(id)){
            pizzaService.delte(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
