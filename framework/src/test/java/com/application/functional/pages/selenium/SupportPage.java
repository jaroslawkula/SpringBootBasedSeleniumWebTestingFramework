package com.application.functional.pages.selenium;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
@Component
public class SupportPage extends AbstractPage {

    @FindBy(css = "body > section > h1")
    private WebElement headerTitle;

    @FindBy(css = "body > section >div > p")
    private WebElement headerContent;

    @PostConstruct
    public void initPageElements() {
        initPageElements(this);
    }

    public void waitForPageToLoad() {
        element.waitForElementPresentAndDisplayed(headerTitle);
        element.waitForElementPresentAndDisplayed(headerContent);
    }
}
