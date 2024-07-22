package com.rca.stock.services;

import com.rca.stock.model.Order;
import com.rca.stock.model.StockItem; // Import StockItem if needed
import com.rca.stock.repository.OrderRepository;
import com.rca.stock.repository.StockItemRepository; // Assume you have a StockItemRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final StockItemRepository stockItemRepository; // Add repository for StockItem

    @Autowired
    public OrderService(OrderRepository orderRepository, StockItemRepository stockItemRepository) {
        this.orderRepository = orderRepository;
        this.stockItemRepository = stockItemRepository;
    }

    // Create a new order
    public Order createOrder(Integer itemId, Date date, String status) {
        Optional<StockItem> optionalStockItem = stockItemRepository.findById(itemId);
        if (optionalStockItem.isPresent()) {
            Order order = new Order();
            order.setStockItem(optionalStockItem.get());
            order.setDate(date);
            order.setStatus(status);
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("StockItem not found");
        }
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update an order
    public Order updateOrder(Integer orderId, String status) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(status);
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    // Delete an order
    public void deleteOrder(Integer orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new RuntimeException("Order not found");
        }
    }
}
