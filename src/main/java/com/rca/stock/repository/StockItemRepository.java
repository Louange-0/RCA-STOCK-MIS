package com.rca.stock.repository;

import com.rca.stock.model.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockItemRepository extends JpaRepository<StockItem, Integer> {
}
