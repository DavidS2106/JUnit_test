package com.example.ConditionalTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.OS;

public class CartConditionalTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "KDavid")
    void onlyOnWindowsAndQAEnv() {
        System.out.println("Runs on Windows & KDavid environment");
    }
}
