package com.application.functional.drivermanager;

import lombok.SneakyThrows;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ChromeDriverManager extends DriverManager {
    private ChromeDriverService service;

    @SneakyThrows
    protected void startService() {
        Path path = Paths.get(getClass().getResource("drivers/chromedriver/89.0.43.89.23/chromedriver.exe")
                .toURI());
        if (null == service) {
            service = new ChromeDriverService.Builder()
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
        ChromeOptions options = new ChromeOptions();
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
        driver = new ChromeDriver(service, options);
    }
}
