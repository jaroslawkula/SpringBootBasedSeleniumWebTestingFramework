package com.application.functional;

import com.application.functional.drivermanager.DriverManager;
import com.application.functional.infrastructure.ApplicationConfiguration;
import com.application.functional.profileresolver.SystemPropertyActiveProfileResolver;
import com.application.functional.url.UrlResolver;
import com.application.functional.utils.ChromeDriverKiller;
import lombok.SneakyThrows;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@SpringBootTest
@ContextConfiguration(classes = ApplicationConfiguration.class)
@ActiveProfiles(value = {"local", "chrome"}, resolver = SystemPropertyActiveProfileResolver.class)
public class SeleniumBase extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebDriver driver;
    @Autowired
    private UrlResolver urlResolver;
    @Autowired
    private DriverManager driverManager;

    private static final Logger logger = LoggerFactory.getLogger(SeleniumBase.class);

    @SneakyThrows
    @BeforeSuite
    public void createDefaultConfiguration() {
        ChromeDriverKiller.killChromeDriverProcesses();
        super.springTestContextPrepareTestInstance();
        Awaitility.ignoreExceptionsByDefault();
        loadPage();
    }

    private void loadPage() {
        driver.get(urlResolver.getAppUrl());
    }

    @AfterMethod
    public void logTestResult(ITestResult result) {
        logger.info(result.getTestClass()
                .getName() + " : " + (result.isSuccess() ? "[PASS]" : "[FAIL]"));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
