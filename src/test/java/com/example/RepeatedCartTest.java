package com.example;

import org.example.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedCartTest {

    private Cart cart;
    private static final List<String> items = List.of("Pen", "Notebook", "Pencil", "Eraser", "Ruler");

    @BeforeEach
    void setup() {
        cart = new Cart();
    }

    @RepeatedTest(value = 5, name = "Adding item {currentRepetition} of {totalRepetitions}")
    void addItemFromListOneByOne(RepetitionInfo repetitionInfo) {
        int index = repetitionInfo.getCurrentRepetition() - 1;
        String item = items.get(index);

        cart.addItem(item, 1);

        // Print the item being added
        System.out.println(item + " added");

        // Assertion to check if item was added
        assertTrue(cart.getItems().containsKey(item));
    }
}
