package com.platzi.platzi_api_jpa.service;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaOrderEntity;
import com.platzi.platzi_api_jpa.persistence.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PizzaOrderService {

    private final PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public List<PizzaOrderEntity> getAll() {
        return pizzaOrderRepository.findAll();
    }

    public List<PizzaOrderEntity> getAllAfterDate() {

        LocalDateTime date = LocalDate.now().atTime(0,0);

        return pizzaOrderRepository.findAllByDateAfter(date);
    }


    public List<PizzaOrderEntity> getOutsideOrders(){

        System.out.println(pizzaOrderRepository.countByMethod("D"));

        List<String> methods= List.of("D", "S");
        return pizzaOrderRepository.findAllByMethodIn(methods);
    }

    public List<PizzaOrderEntity> findCustomerOrders(String id_customer){
        return pizzaOrderRepository.findCustomerOrders(id_customer);
    }

}
