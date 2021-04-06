package com.application.functional.utils.selenium;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Component
public class WebElementUtil {

    @Autowired
    private WebDriver driver;

    @Autowired
    private LocatorExtractor locatorExtractor;

    public List<WebElement> getElements(By by) {
        return driver.findElements(by);
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public boolean isPresent(By by) {
        return CollectionUtils.isNotEmpty(getElements(by));
    }

    public boolean isPresent(WebElement element) {
        return isPresent(locatorExtractor.getLocator(element));
    }

    public boolean isNotPresent(By by) {
        return !isPresent(by);
    }

    public boolean isElementPresentAndDisplayed(By by) {
        return isPresent(by) && getElement(by).isDisplayed();
    }

    public boolean areAllOverlaysHidden(List<By> locators) {
        for (By locator : locators) {
            if (isPresent(locator)) return false;
        }
        return true;
    }

    public void waitForElementPresent(By by) {
        await()
                .alias("Waiting for element : " + by + " present...")
                .atMost(30, TimeUnit.SECONDS)
                .until(() -> isPresent(by));
    }

    public void waitForElementPresent(WebElement element) {
        waitForElementPresent(locatorExtractor.getLocator(element));
    }

    public void waitForElementIsNotPresent(By by) {
        await().pollDelay(1, TimeUnit.SECONDS).until(() -> isNotPresent(by));
    }

    public void waitForElementIsNotPresent(By by, Duration duration) {
        waitForElementIsNotPresent(by, duration, Duration.ofSeconds(1));
    }

    public void waitForElementIsNotPresent(By by, Duration duration, Duration pollDelay) {
        await().pollDelay(pollDelay)
                .atMost(duration)
                .until(() -> isNotPresent(by));
    }

    public void waitForElementDisplayed(WebElement element) {
        await().until(element::isDisplayed);
    }

    public void waitForElementIsNotDisplayed(By by) {
        await().until(() -> !getElement(by).isDisplayed());
    }

    public void waitForElementEnabled(WebElement element) {
        await().until(element::isEnabled);
    }

    public void waitForElementIsNotEnabled(WebElement element) {
        await().until(() -> !element.isEnabled());
    }

    public void waitUntilHasValueAttribute(WebElement element, String value) {
        await().until(() -> element.getAttribute("value").equals(value));
    }

    public void waitForElementPresentAndDisplayed(By by) {
        waitForElementPresent(by);
        waitForElementDisplayed(driver.findElement(by));
    }

    public void waitForElementPresentAndDisplayed(WebElement element) {
        waitForElementPresent(element);
        waitForElementDisplayed(element);
    }

    public void waitForElementAttributeHasValue(By locator, String attribute, String value) {
        waitForElementPresent(locator);
        await().until(() -> getElement(locator).getAttribute(attribute).equals(value));
    }

    public void waitForElementsAreNotPresent(List<By> locators) {
        for (By locator : locators) waitForElementIsNotPresent(locator, Duration.ofSeconds(30), Duration.ofMillis(50));
    }
}