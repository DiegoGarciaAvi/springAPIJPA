package com.platzi.platzi_api_jpa.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
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
