package com.techelevator.farm;

import java.math.BigDecimal;

public class EGG implements Sellable {

    private BigDecimal price;


    public EGG(BigDecimal price) {
        this.price = price;

    }

    @Override
    public String getName() {
        return "EGG";
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
