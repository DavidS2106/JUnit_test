package com.example.exceptionTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import com.example.exceptionTest.CartAssertThrowsTest;
import com.example.exceptionTest.CartTryCatchTest;
import com.example.exceptionTest.CartExpectedExceptionTest;

@Suite
@SelectClasses({
        CartAssertThrowsTest.class,
        CartTryCatchTest.class,
        //CartExpectedExceptionTest.class
})
public class TestSuiteException {
}
