// File: TestMethods.java
// Demo: Writing clean and structured test methods with naming and best practices

package com.example;

import org.example.Cart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestMethods {

    Cart cart;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("🔧 Starting Cart Tests");
    }

    @BeforeEach
    void init() {
        cart = new Cart();
        System.out.println("🔄 New test case");
    }

    @Test
    @DisplayName("Should add one item to the cart")
    void shouldAddItem() {
        cart.addItem("Phone",1);
        assertEquals(1, cart.getItemCount(), "Item count should be 1 after adding one item");
        System.out.println(cart.getItems());
    }

    @Test
    @DisplayName("Should clear all items from the cart")
    void shouldClearCart() {
        cart.addItem("Tablet",1);
        cart.clear();
        assertEquals(0, cart.getItemCount(), "Item count should be 0 after clearing");
        System.out.println(cart.getItems());
    }

    @Test
    @DisplayName("Should throw exception for invalid item")
    void shouldFailOnInvalidItem() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> cart.addItem(" ",1));
        assertEquals("Item cannot be null or empty", ex.getMessage());
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("✅ Test complete");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("🎉 All tests finished");
    }
}
