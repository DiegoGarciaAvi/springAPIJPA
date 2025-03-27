package com.platzi.platzi_api_jpa.service;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaOrderEntity;
import com.platzi.platzi_api_jpa.persistence.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaOrderService {

    private final PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public List<PizzaOrderEntity> getAll(){
        return pizzaOrderRepository.findAll();
    }

}
