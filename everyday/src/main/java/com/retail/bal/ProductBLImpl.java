package com.retail.bal;

import com.retail.dal.ProductDAL;
import com.retail.dal.ProductImpl;
import com.retail.dtos.ApparelDTO;
import com.retail.dtos.ElectronicsDTO;
import com.retail.dtos.FoodItemDTO;
import com.retail.entities.Apparel;
import com.retail.entities.Electronics;
import com.retail.entities.FoodItems;
import com.retail.entities.Product;

public class ProductBLImpl implements ProductBL{

    private ProductDAL productDAL;
    private FoodItemDTO[] foodItemDTOS;
    private ApparelDTO[] apparelDTOS;
    private ElectronicsDTO[] electronicsDTOS;
    private static int foodItemCount;
    private static int apparelCount;
    private static int electronicsCount;


    public ProductBLImpl(int size){

        productDAL=new ProductImpl(size);
    }
    @Override
    public boolean addProduct(Product product) {
        if(product instanceof FoodItems)
            foodItemCount++;
        else if(product instanceof Apparel)
            apparelCount++;
        else
            electronicsCount++;

        return this.productDAL.addProduct(product);
    }

    //return only food items using DTO
    @Override
    public FoodItemDTO[] getAllFoodItems() {

        foodItemDTOS=new FoodItemDTO[foodItemCount];
        int pos=0;
        for(Product product: productDAL.getAllProducts()){
            if(product instanceof  FoodItems){
                FoodItems foodItem= (FoodItems) product;
                foodItemDTOS[pos]=new FoodItemDTO(foodItem.getItemCode(),foodItem.getItemName()
                        ,foodItem.getQty(),foodItem.isVegetarian());
                pos++;
            }
        }
        return foodItemDTOS;
    }

    @Override
    public ApparelDTO[] getAllApparels() {
        apparelDTOS=new ApparelDTO[apparelCount];
        int pos=0;
        for(Product product: productDAL.getAllProducts()){
            if(product instanceof  Apparel){
                Apparel apparel= (Apparel) product;
                apparelDTOS[pos]=new ApparelDTO(apparel.getItemCode(),apparel.getItemName()
                        ,apparel.getQty(),apparel.getMaterial(),apparel.getSize());
                pos++;
            }
        }
        return apparelDTOS;
    }

    @Override
    public ElectronicsDTO[] getAllElectronics() {
        electronicsDTOS=new ElectronicsDTO[electronicsCount];
        int pos=0;
        for(Product product: productDAL.getAllProducts()){
            if(product instanceof Electronics){
                Electronics electronics= (Electronics) product;
                electronicsDTOS[pos]=new ElectronicsDTO(electronics.getItemCode(),electronics.getItemName()
                        ,electronics.getQty(),electronics.getWarranty());
                pos++;
            }
        }
        return electronicsDTOS;
    }

    @Override
    public FoodItemDTO getFoodItemById(long itemCode) {
        FoodItems foodItem= (FoodItems) productDAL.getProductById(itemCode);
        return new FoodItemDTO(foodItem.getItemCode(),foodItem.getItemName()
                ,foodItem.getQty(),foodItem.isVegetarian());
    }

    @Override
    public ApparelDTO getApparelById(long itemCode) {
        Apparel apparel= (Apparel) productDAL.getProductById(itemCode);
        return new ApparelDTO(apparel.getItemCode(),apparel.getItemName()
                ,apparel.getQty(),apparel.getMaterial(),apparel.getSize());
    }

    @Override
    public ElectronicsDTO getElectronicsById(long itemCode) {
        Electronics electronics= (Electronics) productDAL.getProductById(itemCode);
        return new ElectronicsDTO(electronics.getItemCode(),electronics.getItemName()
                ,electronics.getQty(),electronics.getWarranty());
    }
}
