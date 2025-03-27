package com.platzi.platzi_api_jpa.service;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaEntity;
import com.platzi.platzi_api_jpa.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll(){
        return pizzaRepository.findAll();
    }


    public List<PizzaEntity> getAvailable(){
        return pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public List<PizzaEntity> getWithDescription(String description){
        return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getWithoutDescription(String description){
        return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }

    public PizzaEntity getById(Integer id){
        return pizzaRepository.findById(id).orElse(null);
    }

    public PizzaEntity getByName(String name){
        return pizzaRepository.findByAvailableTrueAndNameIgnoreCase(name);
    }

    public PizzaEntity save (PizzaEntity pizzaEntity){
        try {
            return pizzaRepository.save(pizzaEntity);
        } catch (Exception e){
            System.out.println("----------\n"+e);
            return null;
        }
    }

    public void delte(int id){
        pizzaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return pizzaRepository.existsById(id);
    }

}
