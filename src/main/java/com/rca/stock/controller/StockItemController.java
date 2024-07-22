package com.rca.stock.controller;

import com.rca.stock.model.StockItem;
import com.rca.stock.services.StockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-items")
public class StockItemController {

    @Autowired
    private StockItemService stockItemService;

    // Get all items
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public List<StockItem> getAllStockItems() {
        return stockItemService.getAllStockItems();
    }

    // Get a single item
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public StockItem getStockItemById(@PathVariable Integer id) {
        return stockItemService.getStockItemById(id);
    }

    // Create a StockItem
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public StockItem saveStockItem(@RequestBody StockItem stockItem) {
        return stockItemService.saveStockItem(stockItem);
    }

    // Update a StockItem
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public StockItem updateStockItem(@PathVariable Integer id, @RequestBody StockItem stockItem) {
        return stockItemService.updateStockItem(id, stockItem);
    }

    // Delete a StockItem
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public void deleteStockItem(@PathVariable Integer id) {
        stockItemService.deleteStockItem(id);
    }
}
