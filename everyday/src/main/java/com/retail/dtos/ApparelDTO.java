package com.retail.dtos;

import com.retail.entities.Material;
import com.retail.entities.Size;

public record ApparelDTO(long itemCode, String itemName, int qtySold, Material material, Size size) {
}
