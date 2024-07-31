package com.retail.dal;

import com.retail.entities.Product;

public interface ProductDAL {

    boolean addProduct(Product product);
    Product[] getAllProducts();
    Product getProductById(long itemCode);

}
