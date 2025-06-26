package com.example.DisplayNameTest;

import org.example.Cart;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.IndicativeSentences;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("🧪 Cart Behavior Tests:")
@DisplayNameGeneration(IndicativeSentences.class)
class CartIndicativeSentenceTest {

    @Test
    void adding_items_should_increase_count() {
        Cart cart = new Cart();
        cart.addItem("Phone",1);
        cart.addItem("Tablet",1);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void clearing_cart_should_result_in_empty_cart() {
        Cart cart = new Cart();
        cart.addItem("Book",1);
        cart.clear();
        assertTrue(cart.getItems().isEmpty());
    }
}
