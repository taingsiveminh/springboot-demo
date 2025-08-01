package com.minh.demo.model.stock;
import lombok.Data;

@Data
public class UpdateStockModel {
    private Integer operationType; // 1 -> add, 2 -> remove
    private Integer quantity;
}