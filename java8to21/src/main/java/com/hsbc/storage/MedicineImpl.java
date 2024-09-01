package com.hsbc.storage;

import com.hsbc.models.Medicine;
import com.hsbc.models.MedicineType;
import com.hsbc.models.Order;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicineImpl implements MedicineDAL{
    List<Medicine> medicineList;
    Path path;
    public  MedicineImpl(){

        medicineList=new ArrayList<>();
        path= Paths.get("reports/medicine.csv");
    }

    @Override
    public Medicine addMedicine(Medicine medicine) {
        medicineList.add(medicine);

        return medicine;
    }

    @Override
    public Optional<Medicine> updateMedicine(long code, int qty, float price) {
        //stream api
       Optional<Medicine> optionalMedicine=medicineList.stream()
               .filter(m->m.getCode()==code).findFirst();
       Medicine oldMedicine,newMedicine=null;
       if(optionalMedicine.isPresent()){
           oldMedicine=optionalMedicine.get();
           newMedicine=optionalMedicine.get();
           newMedicine.setQty(qty);
           newMedicine.setPrice(price);
           medicineList.remove(oldMedicine);
           medicineList.add(newMedicine);
       }
//returning updated data
return optionalMedicine=medicineList.stream()
        .filter(m->m.getCode()==code).findFirst();

    }

    @Override
    public Medicine searchMedicineByName(String name) {

      return medicineList.stream().filter(m->m.getName().equals(name)).findFirst()
               .orElse(null);
    }

    @Override
    public List<Medicine> searchMedicineByType(MedicineType medicineType) {

       return medicineList.stream().filter(m->m.getMedicineType()
               .equals(medicineType)).toList();
    }

    @Override
    public List<Medicine> getAllMedicines() {

        return medicineList;
    }

    @Override
    public Order purchaseMedicines(List<Long> codes) throws IOException {
        List<Medicine> purchaseList=new ArrayList<>();
        Optional<Medicine> optional=null;
        for(Long code :codes){
           optional= medicineList.stream()
                    .filter(m->m.getCode()==code).findFirst();
           if(optional.isPresent()){
               purchaseList.add(optional.get());
           }
        }

        Order order= new Order(purchaseList, LocalDate.now(),
                (float)purchaseList.stream().mapToDouble(m->m.getPrice()).sum());

        Files.writeString(path,order.toString(),
                StandardOpenOption.APPEND);
        return order;

    }

    @Override
    public String generateReport() throws IOException {
        return Files.readString(path);
    }
}