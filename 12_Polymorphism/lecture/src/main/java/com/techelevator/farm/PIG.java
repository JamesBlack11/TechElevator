package com.techelevator.farm;

import java.math.BigDecimal;

public class PIG extends FarmAnimal implements Sellable{


    public PIG() {
        super("Pig", "Oink!");
    }

    public BigDecimal getPrice() {
        return new BigDecimal(300.00);
    }
}
