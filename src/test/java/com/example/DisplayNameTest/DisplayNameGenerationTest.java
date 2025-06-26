package com.example.DisplayNameTest;

import org.example.Cart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
class DisplayNameGenerationTest {

    @Test
    void item_can_be_added_to_cart() {
        Cart cart = new Cart();
        cart.addItem("Laptop",1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void cart_is_empty_after_clear() {
        Cart cart = new Cart();
        cart.addItem("Tablet",1);
        cart.clear();
        assertEquals(0, cart.getItemCount());
    }
}
