package com.example.assumption;

import org.example.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;

public class CartAssumptionTest {

    @Test
    void testAddItemOnlyIfUserIsLoggedIn() {
        boolean userLoggedIn = false;

        assumeTrue(userLoggedIn, "User must be logged in to add items");

        Cart cart = new Cart();
        cart.addItem("Phone",1);

        System.out.println("Item added to cart!");
    }

    @Test
    void testCartClearIfNotGuestUser() {
        boolean isGuest = true;

        assumeFalse(isGuest, "Guest users cannot clear the cart");

        Cart cart = new Cart();
        cart.addItem("Tablet",1);
        cart.clear();

        System.out.println("Cart cleared by registered user");
    }

    @Test
    void testDiscountOnlyInIndia() {
        String country = "India";

        Cart cart = new Cart();
        cart.addItem("Laptop",1);

        // Conditional execution inside test
        assumingThat("India".equals(country), () -> {
            System.out.println("Applying India discount logic");
        });

        System.out.println("Cart ready: " + cart);
    }
}
