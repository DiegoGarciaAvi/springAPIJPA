package com.platzi.platzi_api_jpa.web.controller;

import com.platzi.platzi_api_jpa.persistence.entity.CustomerEntity;
import com.platzi.platzi_api_jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> findByPhone(@PathVariable String phone){
        return ResponseEntity.ok(customerService.findByPhone(phone));
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }
}
