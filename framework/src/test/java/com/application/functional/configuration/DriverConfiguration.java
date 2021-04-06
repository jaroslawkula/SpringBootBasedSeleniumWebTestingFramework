package com.application.functional.configuration;

import com.application.functional.drivermanager.DriverManager;
import com.application.functional.infrastructure.TestProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DriverManagerConfiguration.class, TestProperties.class})
public class DriverConfiguration {

    @Autowired
    private DriverManager driverManager;

    @Autowired
    private TestProperties testProperties;

    @Bean
    public WebDriver driver() {
        return driverManager.getDriver();
    }

    @Bean(destroyMethod = "")
    public JavascriptExecutor javascriptExecutor() {
        return (JavascriptExecutor) driver();
    }
}
