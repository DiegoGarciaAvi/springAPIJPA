package com.platzi.platzi_api_jpa.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @Column(name = "id_customer",nullable = false)
    private String idCustomer;

    @Column(nullable = false,length = 150)
    private String address;

    @Column(nullable = false,length = 100)
    private String email;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 15)
    private String phone_number;

}
