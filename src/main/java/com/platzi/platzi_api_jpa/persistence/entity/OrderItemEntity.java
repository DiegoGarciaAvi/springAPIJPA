package com.platzi.platzi_api_jpa.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemEntityPK.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @Column(name = "id_item",nullable = false)
    private Integer idItem;

    @Id
    @Column(name = "id_order",nullable = false)
    private Integer idOrder;

    @Column(name = "id_pizza",nullable = false)
    private Integer idPizza;

    @Column(nullable = false,columnDefinition = "DECIMAL(6,2)")
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_order",columnDefinition = "id_order",insertable = false,updatable = false)
    @JsonIgnore
    private PizzaOrderEntity pizzaOrder;

    @OneToOne
    @JoinColumn(name = "id_pizza",columnDefinition = "id_pizza",insertable = false,updatable = false)
    private PizzaEntity pizza;

}
