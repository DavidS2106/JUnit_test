package com.example.exceptionTest;

import org.example.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class CartTryCatchTest {

    private final Cart cart = new Cart();

    @Test
    void addItemWithEmptyProductId_shouldThrow() {
        try {
            cart.addItem("   ", 1);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().contains("Product ID cannot be null or empty"));
        }
    }
}
