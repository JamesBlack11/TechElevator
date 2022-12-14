package com.techelevator.farm;

import java.math.BigDecimal;

public class Tractor implements Singable, Sellable{


    private String name;
    private String sound;

    public Tractor() {
        this.name = "Tractor";
        this.sound = "put put";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(250000.00);
    }

    @Override
    public String getSound() {
        return sound;
    }
}
