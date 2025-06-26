package com.example.ConditionalTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class CartSystemPropertyTest {

    @Test
    @EnabledIfSystemProperty(named = "env", matches = "staging")
    void runOnlyOnStaging() {
        System.out.println("Runs only when -Denv=staging is set");
    }
}
