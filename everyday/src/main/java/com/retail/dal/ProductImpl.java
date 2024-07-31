package com.retail.dal;

import com.retail.entities.Product;

public class ProductImpl implements ProductDAL {
    private Product[] products;
    private static int pos=0;

    public ProductImpl(int size){
        products=new Product[size];
    }

    @Override
    public boolean addProduct(Product product) {
        if(pos<products.length) {
            products[pos] = product;
            pos++;
        }
        return true;
    }

    @Override
    public Product[] getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(long itemCode) {
        Product product=null;
       for(int pos=0; pos<products.length;pos++){

           if((products[pos]!=null)&&(products[pos].getItemCode()==itemCode)){
               product=products[pos];
               break;
           }
       }
       return product;
    }
}
