package com.example;

import org.example.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedCartTest {

    enum Product {
        PHONE, LAPTOP, TABLET
    }

    @ParameterizedTest
    @ValueSource(strings = {"Phone", "Laptop", "Book"})
    @DisplayName("✅ Add single items with @ValueSource")
    void testAddItemsWithValueSource(String item) {
        Cart cart = new Cart();
        cart.addItem(item, 1);  // ✅ Fixed: added quantity
        assertEquals(1, cart.getItemCount());
        System.out.println("Cart: " + cart);
    }

    @ParameterizedTest
    @CsvSource({
            "Phone, 1",
            "Laptop, 1",
            "Mouse, 1"
    })
    @DisplayName("📦 Add items and validate count using @CsvSource")
    void testAddItemsWithCsvSource(String item, int expectedCount) {
        Cart cart = new Cart();
        cart.addItem(item, expectedCount);  // ✅ Use expectedCount as quantity
        assertEquals(expectedCount, cart.getItemCount());
        System.out.println("Cart: " + cart);
    }

    static Stream<Arguments> itemProvider() {
        return Stream.of(
                Arguments.of("Tablet", 1),
                Arguments.of("Keyboard", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("itemProvider")
    @DisplayName("🛠 Add items from method source")
    void testAddItemsWithMethodSource(String item, int expectedCount) {
        Cart cart = new Cart();
        cart.addItem(item, expectedCount);  // ✅ Fixed
        assertEquals(expectedCount, cart.getItemCount());
        System.out.println("Cart: " + cart);
    }

    @ParameterizedTest
    @EnumSource(Product.class)
    @DisplayName("🧪 Add enum products using @EnumSource")
    void testAddItemsWithEnumSource(Product product) {
        Cart cart = new Cart();
        cart.addItem(product.name(), 1);  // Fixed: added quantity
        assertTrue(cart.getItems().containsKey(product.name()));  // ✅ Use containsKey for Map
        System.out.println("Cart: " + cart);
    }
}
