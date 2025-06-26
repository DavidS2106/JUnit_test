package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeoutTest {

    @Test
    @Order(1)
    @Timeout(1) // 1 second
    void testShouldCompleteWithin1Second() throws InterruptedException {
        Thread.sleep(500); // will pass
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(2)
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Should fail after 500ms due to timeout")
    void testShouldFailAfter500ms() throws InterruptedException {
        Thread.sleep(2000); // will fail due to timeout
        assertEquals(2, 1 + 1);
    }
}
