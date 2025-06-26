package com.example.exceptionTest;

import org.example.Cart;
import org.junit.Test;

public class CartExpectedExceptionTest {

    private final Cart cart = new Cart();

    @Test(expected = IllegalArgumentException.class)
    public void addItemWithZeroQuantity_shouldThrowException() {
        cart.addItem("item-001", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemWithNullProductId_shouldThrowException() {
        cart.addItem(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemWithEmptyProductId_shouldThrowException() {
        cart.addItem("   ", 2);
    }
}
