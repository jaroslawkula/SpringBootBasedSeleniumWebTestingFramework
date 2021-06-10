package com.application.functional.configuration;

import com.application.functional.utils.browser.process.DriverKiller;
import com.application.functional.utils.browser.process.EdgeDriverKiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("msedge")
@Configuration
public class EdgeKillerConfig implements DriverKiller {

    @Autowired
    private EdgeDriverKiller edgeDriverKiller;

    public void kill() {
        edgeDriverKiller.kill();
    }
}
