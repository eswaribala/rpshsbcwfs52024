package com.retail.bal;

import com.retail.dtos.ApparelDTO;
import com.retail.dtos.ElectronicsDTO;
import com.retail.dtos.FoodItemDTO;
import com.retail.entities.Electronics;
import com.retail.entities.Product;

public interface ProductBL {

    boolean addProduct(Product product);
    FoodItemDTO[] getAllFoodItems();
    ApparelDTO[] getAllApparels();
    ElectronicsDTO[] getAllElectronics();
    FoodItemDTO getFoodItemById(long itemCode);
    ApparelDTO getApparelById(long itemCode);
    ElectronicsDTO getElectronicsById(long itemCode);
}
