package com.application.functional.infrastructure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "test")
public class TestProperties {
    private String timeoutInSeconds;
    private String protocol;
    private String host;
    private Integer port;
    private String appUrlPath;
}
