package com.platzi.platzi_api_jpa.persistence.repository;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {



}
