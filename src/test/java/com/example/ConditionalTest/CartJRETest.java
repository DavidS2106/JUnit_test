package com.example.ConditionalTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class CartJRETest {

    @Test
    @DisabledOnJre(JRE.JAVA_17)
    void notOnJava17() {
        System.out.println("This test will be skipped on Java 17");
    }
}
