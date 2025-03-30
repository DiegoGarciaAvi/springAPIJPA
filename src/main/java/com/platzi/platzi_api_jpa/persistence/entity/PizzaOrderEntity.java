package com.platzi.platzi_api_jpa.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
@NoArgsConstructor
public class PizzaOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order",nullable = false)
    private Integer idOrder;

    @Column(name = "id_customer",nullable = false,length = 15)
    private String idCustomer;

    @Column(nullable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @Column(nullable = false,columnDefinition = "DECIMAL(6,2)")
    private Double total;

    @Column(nullable = false,length = 1)
    private String method;

    @Column(name = "additional_notes",length = 200)
    private String additionalNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer",columnDefinition = "id_customer",insertable = false,updatable = false)
    @JsonIgnore
    private CustomerEntity customer;

    @OneToMany(mappedBy = "pizzaOrder", fetch = FetchType.EAGER)
    @OrderBy("price ASC")
    private List<OrderItemEntity> items;


}
