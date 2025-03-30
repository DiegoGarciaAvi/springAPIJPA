package com.platzi.platzi_api_jpa.service;

import com.platzi.platzi_api_jpa.persistence.entity.CustomerEntity;
import com.platzi.platzi_api_jpa.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository custumerRepository;

    @Autowired
    public CustomerService(CustomerRepository custumerRepository) {
        this.custumerRepository = custumerRepository;
    }

    public CustomerEntity findByPhone(String phone){
        return custumerRepository.findByPhone(phone);
    }

    public List<CustomerEntity> getAll(){
        return custumerRepository.findAll();
    }

}
