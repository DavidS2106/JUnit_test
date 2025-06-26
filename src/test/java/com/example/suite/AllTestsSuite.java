package com.example.suite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
        "com.example.unit",
        "com.example.integration"
})
public class AllTestsSuite {
}
