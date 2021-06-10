package com.application.functional.configuration;

import com.application.functional.utils.browser.process.ChromeDriverKiller;
import com.application.functional.utils.browser.process.DriverKiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("chrome")
@Configuration
public class ChromeKillerConfig implements DriverKiller {

    @Autowired
    private ChromeDriverKiller chromeDriverKiller;

    public void kill() {
        chromeDriverKiller.kill();
    }
}
