package com.retail.entities;
//abstract --> factory pattern super type
public abstract sealed class Product permits Apparel, Electronics, FoodItems {


    protected long itemCode;
    protected String itemName;
    protected int unitPrice;
    protected int qty;

    public Product() {
    }

    public Product(long itemCode, String itemName, int unitPrice, int qty) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }


    public long getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
