package com.platzi.platzi_api_jpa.persistence.repository;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaOrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, Integer> {

    List<PizzaOrderEntity> findAllByDateAfter(LocalDateTime date);

    List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);

    int countByMethod(String method);

}
