package com.platzi.platzi_api_jpa.persistence.repository;

import com.platzi.platzi_api_jpa.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity,String > {

    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phone_number=:phone")
    CustomerEntity findByPhone(@Param("phone") String phone);

}
