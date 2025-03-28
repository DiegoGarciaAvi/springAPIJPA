package com.platzi.platzi_api_jpa.service;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaEntity;
import com.platzi.platzi_api_jpa.persistence.repository.PizzaPagSortRepository;
import com.platzi.platzi_api_jpa.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    public Page<PizzaEntity> getAll(int page, int elements){
        Pageable pageable = PageRequest.of(page, elements);
        return pizzaPagSortRepository.findAll(pageable);
    }


    public Page<PizzaEntity> getAvailable(int page,int elements,String sortBy,String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pegeable = PageRequest.of(page,elements, sort);
        return pizzaPagSortRepository.findByAvailableTrue(pegeable);
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
        return pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("Pizza not found"));
    }

    public List<PizzaEntity> getByPrice(double price){
        return pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
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
