package com.application.functional.infrastructure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TestProperties.class)
@ComponentScan(value={
        "com.application.functional"
})
public class ApplicationConfiguration {
}
