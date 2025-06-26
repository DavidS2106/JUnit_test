package com.example.exceptionTest;

import org.example.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartAssertThrowsTest {

    private final Cart cart = new Cart();

    @Test
    void addItemWithZeroQuantity_throwsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("item-001", 0);
        });

        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void addItemWithNullProductId_throwsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem(null, 1);
        });

        assertEquals("Product ID cannot be null or empty", exception.getMessage());
    }
}
