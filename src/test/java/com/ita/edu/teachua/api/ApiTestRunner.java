package com.ita.edu.teachua.api;

import com.ita.edu.teachua.utils.CredentialsValueProvider;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ApiTestRunner {
    protected static TestValueProvider provider;
    protected static CredentialsValueProvider providerCredentials;

    @BeforeSuite
    public void setUp() throws IOException {
        if (provider == null) {
            provider = new TestValueProvider();
        }
        if (providerCredentials == null) {
            providerCredentials = new CredentialsValueProvider();
        }
    }
}
