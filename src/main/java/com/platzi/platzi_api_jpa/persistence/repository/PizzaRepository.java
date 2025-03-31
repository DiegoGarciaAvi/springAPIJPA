package com.platzi.platzi_api_jpa.persistence.repository;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaEntity;
import com.platzi.platzi_api_jpa.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);

    @Query(value = "Update pizza set price = :#{#updatePizzaPriceDto.newPrice} where id_pizza = :#{#updatePizzaPriceDto.pizzaId}" , nativeQuery = true)
    @Modifying
    void updatePrice(@Param("updatePizzaPriceDto")UpdatePizzaPriceDto updatePizzaPriceDto);

}
