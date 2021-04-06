package com.application.functional.configuration;

import com.application.functional.drivermanager.DriverManager;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DriverManagerConfiguration.class)
public class ActionsConfiguration {
    @Autowired
    private DriverManager driverManager;

    @Bean
    public Actions actions() {
        return new Actions(driverManager.getDriver());
    }
}
