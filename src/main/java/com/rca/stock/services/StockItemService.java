package com.rca.stock.services;

import com.rca.stock.model.StockItem;
import com.rca.stock.repository.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockItemService {

    @Autowired
    private StockItemRepository stockItemRepository;

    public List<StockItem> getAllStockItems() {
        return stockItemRepository.findAll();
    }

    public StockItem getStockItemById(Integer id) {
        return stockItemRepository.findById(id).orElse(null);
    }

    public StockItem saveStockItem(StockItem stockItem) {
        return stockItemRepository.save(stockItem);
    }

    public StockItem updateStockItem(Integer id, StockItem stockItem) {
        return stockItemRepository.findById(id).map(existingStockItem -> {
            existingStockItem.setName(stockItem.getName());
            existingStockItem.setCategory(stockItem.getCategory());
            existingStockItem.setQuantity(stockItem.getQuantity());
            existingStockItem.setPrice(stockItem.getPrice());
            return stockItemRepository.save(existingStockItem);
        }).orElse(null);
    }

    public void deleteStockItem(Integer id) {
        stockItemRepository.deleteById(id);
    }
}
