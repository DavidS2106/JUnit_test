package com.example;

import org.example.Cart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("📦 Cart Test Suite")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NestedCartTest {

    Cart cart;

    @BeforeEach
    void setup() {
        cart = new Cart();
        System.out.println("🔁 New test setup");
    }

    @Nested
    @DisplayName("✅ Add Item Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class AddItemTests {

        @Test
        @Order(1)
        @DisplayName("Add invalid item")
        void testAddInvalidItem() {
            assertThrows(IllegalArgumentException.class, () -> cart.addItem("",1));
            System.out.println("Adding invalid items     " + cart.toString());
        }

        @Test
        @Order(2)
        @DisplayName("Add valid item")
        void testAddValidItem() {
            cart.addItem("Laptop",1);
            assertEquals(1, cart.getItemCount());
            System.out.println("Adding Valid Item     " + cart.toString());
        }
    }

    @Nested
    @DisplayName("🧹 Clear Cart Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ClearCartTests {

        @Test
        @Order(1)
        @DisplayName("Clear already empty cart")
        void testClearEmptyCart() {
            cart.clear();
            assertEquals(0, cart.getItemCount());
            System.out.println("Cleared already empty cart:   " + cart.toString());
        }

        @Test
        @Order(2)
        @DisplayName("Clear cart after adding items")
        void testClearCart() {
            cart.addItem("Phone",1);
            cart.addItem("Mouse",1);
            System.out.println("Before Clearing cart:   " + cart.toString());
            cart.clear();
            assertEquals(0, cart.getItemCount());
            System.out.println("After Clearing cart:   " + cart.toString());
        }
    }
}
