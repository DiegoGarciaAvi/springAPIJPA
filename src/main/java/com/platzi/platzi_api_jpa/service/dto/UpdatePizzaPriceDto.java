package com.platzi.platzi_api_jpa.service.dto;

import lombok.Data;

@Data
public class UpdatePizzaPriceDto {

    private int pizzaId;
    private double newPrice;

}
