package com.platzi.platzi_api_jpa.persistence.audit;

import com.platzi.platzi_api_jpa.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {

    private PizzaEntity pizzaEntity;

    @PostLoad
    public void postLoad(PizzaEntity pizzaEntity) {
        System.out.println("POST LOAD ");
        this.pizzaEntity= SerializationUtils.clone(pizzaEntity);

    }

    @PostPersist
    @PostUpdate
    public void onPostPersit(PizzaEntity pizzaEntity) {
        System.out.println("POST PERSIST OR UPDATE ");
        System.out.println("old: " + this.pizzaEntity);
        System.out.println("new: " + pizzaEntity.toString());
    }

    @PreRemove
    public void onPreDelete(PizzaEntity pizzaEntity) {
        System.out.println("PizzaEntity: " + pizzaEntity);
    }

}
