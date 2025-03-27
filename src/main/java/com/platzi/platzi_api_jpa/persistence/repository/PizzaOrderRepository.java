package com.platzi.platzi_api_jpa.persistence.repository;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaOrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, Integer> {
}
