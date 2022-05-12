package com.ita.edu.teachua.api;

import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ApiTestRunner {
    protected static TestValueProvider provider;

    @BeforeSuite
    public void setUp() throws IOException {
        if (provider == null) {
            provider = new TestValueProvider();
        }
    }
}
