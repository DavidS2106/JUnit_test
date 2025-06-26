// File: BeforeAllTest.java
// Demo: JUnit test lifecycle methods (BeforeAll, BeforeEach, AfterEach, AfterAll)

package com.example;

import org.example.Cart;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    Cart cart;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Cart Tests");
    }

    @BeforeEach
    void setup() {
        cart = new Cart();
        System.out.println("New test starting");
    }

    @Test
    @DisplayName("Add item to cart")
    void testAddItem() {
        cart.addItem("Laptop",1);
        assertEquals(1, cart.getItemCount());
        System.out.println("Laptop Added to cart");
    }

    @Test
    @DisplayName("Clear cart")
    void testClearCart() {
        cart.addItem("Mouse",1);
        cart.clear();
        assertEquals(0, cart.getItemCount());
        System.out.println("Mouse Added to cart");
    }

    @Test
    @DisplayName("Add null item should fail")
    void testAddInvalidItem() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("",1));
    }

    @AfterEach
    void tearDown() {
        System.out.println("✅ Test complete");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("🎉 All Cart tests done");
    }
}