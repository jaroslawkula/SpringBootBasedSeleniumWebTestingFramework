package com.application.functional.url;


import com.application.functional.infrastructure.TestProperties;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class UrlResolver {
    @Autowired
    private TestProperties testProperties;

    @SneakyThrows
    public String getAppUrl() {
        return new URL(testProperties.getProtocol(),
                testProperties.getHost(),
                testProperties.getPort(),
                testProperties.getAppUrlPath()).toString();
    }
}
