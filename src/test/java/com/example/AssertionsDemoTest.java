package com.example;

import org.example.Cart;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AssertionsDemoTest {

    @Test
    @Order(2)
    @DisplayName("assertEquals - item count matches expected")
    void testAssertEquals() {
        Cart cart = new Cart();
        cart.addItem("Phone",1);
        assertEquals(1, cart.getItemCount(), "Item count should be 1");
        System.out.println(cart.toString());
    }

    @Test
    @Order(3)
    @DisplayName("assertTrue - item is present in cart")
    void testAssertTrue() {
        Cart cart = new Cart();
        cart.addItem("Book",1);
        assertTrue(cart.getItems().containsKey("Book"), "Cart should contain 'Book'");
        System.out.println(cart.toString());
    }

    @Test
    @Order(1)
    @DisplayName("assertThrows - invalid item throws exception")
    void testAssertThrows() {
        Cart cart = new Cart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("",1);
        });
        assertEquals("Item cannot be null or empty", exception.getMessage());
        System.out.println(cart.toString());
    }

    @Test
    @Order(4)
    @DisplayName("assertAll - group multiple checks")
    void testAssertAll() {
        Cart cart = new Cart();
        cart.addItem("Laptop",1);
        cart.addItem("Mouse",1);

        List<String> items = new ArrayList<>(cart.getItems().keySet());

        assertAll("Cart item checks",
                () -> assertEquals(2, items.size(), "Cart should have 2 items"),
                () -> assertTrue(items.contains("Laptop")),
                () -> assertTrue(items.contains("Mouse"))
        );
        System.out.println(cart.toString());
    }

    @Test
    @Order(5)
    @DisplayName("assertNotNull - ensure items list is returned")
    void testAssertNotNull() {
        Cart cart = new Cart();
        assertNotNull(cart.getItems(), "getItems() should not return null");
    }
}
