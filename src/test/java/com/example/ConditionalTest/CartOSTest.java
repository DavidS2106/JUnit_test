package com.example.ConditionalTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class CartOSTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void runOnlyOnWindows() {
        System.out.println("This runs only on Windows");
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void runOnUnixLikeOS() {
        System.out.println("This runs only on Linux or macOS");
    }
}
