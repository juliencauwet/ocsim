package com.ocsin.test.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdProfile implements DataSourceConfiguration {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for PROD environment. ");
    }

}
