package com.application.functional.drivermanager;

import lombok.SneakyThrows;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MsEdgeDriverManager extends DriverManager {
    private EdgeDriverService service;

    @SneakyThrows
    protected void startService() {
        Path path = Paths.get(getClass().getResource("drivers/msedgedriver/89.0.774.68/msedgedriver.exe")
                .toURI());
        if (null == service) {
            service = new EdgeDriverService.Builder()
                    .usingDriverExecutable(path.toFile())
                    .usingAnyFreePort()
                    .build();
            service.start();
        }
    }

    @Override
    protected void stopService() {
        if (null != service && service.isRunning()) {
            service.stop();
        }
    }

    @Override
    protected void createDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--window-position=3841,0");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
//        options.addArguments("--auto-open-devtools-for-tabs");
        options.setAcceptInsecureCerts(true);
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.setExperimentalOption("download.default_directory", "c:\\Users\\JohnDoe\\Downloads\\");
//        options.setExperimentalOption("download.prompt_for_download", false);
//        options.setExperimentalOption("profile.default_content_settings.popups", 0);
        driver = new EdgeDriver(service, options);
    }
}
