package com.platzi.platzi_api_jpa.persistence.repository;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaOrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, Integer> {

    List<PizzaOrderEntity> findAllByDateAfter(LocalDateTime date);

    List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);

    int countByMethod(String method);

    @Query(value = "Select * from pizza_order where id_customer=:id_customer",nativeQuery = true)
    List<PizzaOrderEntity> findCustomerOrders(@Param("id_customer") String id_customer);

}
