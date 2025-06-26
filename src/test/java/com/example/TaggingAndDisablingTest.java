package com.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

public class TaggingAndDisablingTest {

    @Test
    @Tag("smoke")
    void smokeTest() {
        System.out.println("Running smoke test");
        assertTrue(2 > 1);
    }

    @Test
    @Tag("regression")
    void regressionTest() {
        System.out.println("Running regression test");
        assertEquals(4, 2 * 2);
    }

    @Test
    @Disabled("Waiting for backend service to be available")
    void disabledTest() {
        System.out.println("This should not be printed");
        fail("This test is disabled");
    }
}
