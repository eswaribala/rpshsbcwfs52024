package com.retail.entities;

public non-sealed class Electronics extends Product{

    private int warranty;

    public Electronics() {
    }

    public Electronics(long itemCode, String itemName, int unitPrice, int qty, int warranty) {
        super(itemCode, itemName, unitPrice, qty);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public String toString() {
        return "Electronics{" +super.toString()+
                "warranty=" + warranty +
                '}';
    }
}
