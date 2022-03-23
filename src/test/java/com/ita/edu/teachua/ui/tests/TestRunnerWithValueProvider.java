package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestRunnerWithValueProvider extends TestRunner {
    protected static TestValueProvider valueProvider;
    @BeforeSuite
    public void beforeSuite() throws IOException {
        if (valueProvider == null) {
            valueProvider = new TestValueProvider();
        }
    }
}
