package com.example.ConditionalTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class CartEnvVarTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "KDavid")
    void runOnlyForAdminUser() {
        System.out.println("Runs only for admin user KDavid");
    }
}
