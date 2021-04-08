package com.application.functional.configuration;

import com.application.functional.drivermanager.ChromeDriverManager;
import com.application.functional.drivermanager.DriverManager;
import com.application.functional.drivermanager.MsEdgeDriverManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DriverManagerConfiguration {

    @Bean
    @Profile("chrome")
    public DriverManager chromeDriverManager() {
        return new ChromeDriverManager();
    }

    @Bean
    @Profile("msedge")
    public DriverManager msEdgeDriverManager(){ return new MsEdgeDriverManager();}
}
