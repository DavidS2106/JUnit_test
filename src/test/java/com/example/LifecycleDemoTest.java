package com.example;

import org.example.Cart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // Required for @BeforeAll non-static
public class LifecycleDemoTest {

    Cart cart;

    @BeforeAll
    void beforeAllTests() {
        System.out.println("🔵 @BeforeAll - Runs ONCE before all tests");
    }

    @BeforeEach
    void setup() {
        cart = new Cart(); // Fresh cart before every test
        System.out.println("🟢 @BeforeEach - Runs before EACH test");
    }

    @Test
    @DisplayName("Test 1 - Add one item")
    void testAddItem() {
        cart.addItem("Apple",1);
        assertEquals(1, cart.getItemCount());
        System.out.println("✅ Test 1 executed");
    }

    @Test
    @DisplayName("Test 2 - Cart starts empty each time")
    void testCartStartsEmpty() {
        assertEquals(0, cart.getItemCount(), "Cart should be empty before test");
        System.out.println("✅ Test 2 executed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("🟠 @AfterEach - Clean up after EACH test");
    }

    @AfterAll
    void afterAllTests() {
        System.out.println("🔴 @AfterAll - Runs ONCE after all tests");
    }
}
