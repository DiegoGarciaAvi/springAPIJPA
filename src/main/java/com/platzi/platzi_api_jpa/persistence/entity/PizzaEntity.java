package com.platzi.platzi_api_jpa.persistence.entity;

import com.platzi.platzi_api_jpa.persistence.audit.AuditPizzaListener;
import com.platzi.platzi_api_jpa.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;


@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class, AuditPizzaListener.class})
public class PizzaEntity extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza",nullable = false)
    private Integer idPizza;

    @Column(nullable = false,unique = true,length = 45)
    private String name;

    @Column(nullable = false,length = 150)
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    private Boolean vegetarian;

    private Boolean vegan;

    private Boolean available;

    @Override
    public String toString() {
        return "PizzaEntity{" +
                "idPizza=" + idPizza +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", available=" + available +
                '}';
    }
}
