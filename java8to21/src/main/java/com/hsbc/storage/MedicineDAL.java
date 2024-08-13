package com.hsbc.storage;

import com.hsbc.models.Medicine;
import com.hsbc.models.MedicineType;
import com.hsbc.models.Order;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MedicineDAL {

    Medicine addMedicine(Medicine medicine);
    Optional<Medicine> updateMedicine(long code, int qty, float price);
    Medicine searchMedicineByName(String name);
    List<Medicine> searchMedicineByType(MedicineType medicineType);
    List<Medicine> getAllMedicines();
    Order purchaseMedicines(List<Long> codes) throws IOException;

    String generateReport() throws IOException;



}
