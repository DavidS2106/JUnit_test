package org.example;

import java.util.*;

public class Cart {

    private final Map<String, Integer> items = new HashMap<>();

    public void addItem(String productId, int quantity) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        items.put(productId, items.getOrDefault(productId, 0) + quantity);
    }

    public int getItemCount() {
        return items.size();
    }

    public Map<String, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        return "Cart items: " + items;
    }
}
