package com.retail.entities;

import java.time.LocalDate;

public non-sealed class FoodItems extends Product{
    //dom- Date of Manufacturing
    //doe - Date of Expiry
    private LocalDate dom;
    private LocalDate doe;

    private boolean vegetarian;

    public FoodItems() {
    }

    public FoodItems(long itemCode, String itemName, int unitPrice, int qty, LocalDate dom, LocalDate doe, boolean vegetarian) {
        super(itemCode, itemName, unitPrice, qty);
        this.dom = dom;
        this.doe = doe;
        this.vegetarian = vegetarian;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public String toString() {
        return "FoodItems{" +super.toString()+
                "dom=" + dom +
                ", doe=" + doe +
                ", vegetarian=" + vegetarian +
                '}';
    }
}
