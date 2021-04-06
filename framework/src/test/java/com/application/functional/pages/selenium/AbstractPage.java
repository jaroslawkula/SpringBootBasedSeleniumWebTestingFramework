package com.application.functional.pages.selenium;

import com.application.functional.infrastructure.TestProperties;
import com.application.functional.utils.selenium.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.awaitility.Awaitility.await;

@Component
public class AbstractPage {
    @Autowired
    private WebDriver driver;
    @Autowired
    protected TestProperties testProperties;
    @Autowired
    protected WebElementUtil element;

    public void waitForPageToLoad(WebElement... elements){
        Arrays.asList(elements).forEach(element -> await().until(element::isDisplayed));
    }

    public void waitForPageToLoad(By... locators){
        Arrays.asList(locators).forEach(locator -> await().until(() -> element.isPresent(locator)));
        Arrays.stream(locators).map(locator -> driver.findElement(locator)).forEach(WebElement::isDisplayed);
    }

    protected void initPageElements(Object page){
        PageFactory.initElements(driver, page);
    }
}
