package com.application.functional.tests;

import com.application.functional.SeleniumBase;
import com.application.functional.assertions.WebElementAssert;
import com.application.functional.pages.selenium.SupportPage;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

@Test
public class SeleniumSupportPageTests extends SeleniumBase {

    @Autowired
    private SupportPage supportPage;

    public void shouldDisplayCorrectTitleAndContent() {
        val title = "Getting Help";
        val content = "If you find any problems using Selenium, there are several places where you can search for help " +
                "and where volunteers\nlike you and me will spend their time trying to help you save yours.";

        supportPage.waitForPageToLoad();

        WebElementAssert.assertThat(supportPage.getHeaderTitle())
                .isDisplayed()
                .hasText(title);
        WebElementAssert.assertThat(supportPage.getHeaderContent())
                .isDisplayed()
                .hasText(content);
    }
}
