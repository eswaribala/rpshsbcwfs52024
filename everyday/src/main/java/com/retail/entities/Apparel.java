package com.retail.entities;

public non-sealed class Apparel extends Product{

    private Size size;
    private Material material;

    public Apparel() {
    }

    public Apparel(long itemCode, String itemName, int unitPrice, int qty, Size size, Material material) {
        super(itemCode, itemName, unitPrice, qty);
        this.size = size;
        this.material = material;
    }

    public Size getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Apparel{" +super.toString()+
                "size=" + size +
                ", material=" + material +
                '}';
    }
}
