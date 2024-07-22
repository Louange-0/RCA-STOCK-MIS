package com.rca.stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "_stock_item")
public class StockItem {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String category;
    private double quantity;
    private BigDecimal price;

}
