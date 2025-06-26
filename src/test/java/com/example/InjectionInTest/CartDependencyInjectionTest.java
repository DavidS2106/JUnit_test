package com.example.InjectionInTest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Needed for constructor injection
public class CartDependencyInjectionTest {

    private final TestInfo constructorTestInfo;

    public CartDependencyInjectionTest(TestInfo testInfo) {
        this.constructorTestInfo = testInfo;
        System.out.println("🔧 Constructor injected with TestInfo: " + testInfo.getDisplayName());
    }

    @BeforeAll
    void beforeAll(TestInfo testInfo) {
        System.out.println("📦 BeforeAll - Class: " + testInfo.getTestClass().orElse(null));
    }

    @Test
    @DisplayName("Add item and report with TestReporter")
    void testAddItem(TestInfo testInfo, TestReporter reporter) {
        reporter.publishEntry("Running: " + testInfo.getDisplayName());
        reporter.publishEntry("Tags: " + testInfo.getTags());

        Assertions.assertTrue(true);
    }

    @Test
    void anotherTestWithInjectedInfo(TestInfo testInfo) {
        System.out.println("🧪 Running test: " + testInfo.getDisplayName());
        Assertions.assertNotNull(testInfo.getTestMethod());
    }
}
