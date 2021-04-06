package com.application.functional.assertions;

import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.*;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement webElement) {
        return new WebElementAssert(webElement);
    }

    public WebElementAssert isDisplayed() {
        isNotNull();
        if (!actual.isDisplayed()) {
            failWithMessage("Expected element to be displayed. But was not!!");
        }
        return this;
    }

    public WebElementAssert isNotDisplayed() {
        isNotNull();
        if (actual.isDisplayed()) {
            failWithMessage("Expected element to be not displayed. But was!!");
        }
        return this;
    }

    public WebElementAssert isEnabled() {
        isNotNull();
        if (!actual.isEnabled()) {
            failWithMessage("Expected element to be enabled. But was not!!");
        }
        return this;
    }

    public WebElementAssert isNotEnabled() {
        isNotNull();
        if (actual.isEnabled()) {
            failWithMessage("Expected element to be not enabled. But was!!");
        }
        return this;
    }

    public WebElementAssert isButton() {
        isNotNull();
        if (!(actual.getTagName().equalsIgnoreCase("button") || actual.getAttribute("type").equalsIgnoreCase("button"))) {
            failWithMessage("Expected element to be a button. But was not!!");
        }
        return this;
    }

    public WebElementAssert isLink() {
        isNotNull();
        if (!actual.getTagName().equalsIgnoreCase("a")) {
            failWithMessage("Expected element to be a link. But was not!!");
        }

        return this;
    }

    public WebElementAssert hasAttributeValue(String attr, String value) {
        isNotNull();
        String attribute = actual.getAttribute(attr);
        if (!attribute.equals(value)) {
            failWithMessage("Expected element to have attr <%s> value as <%s>. But was <%s>", attr, value, attribute);
        }
        return this;
    }

    public WebElementAssert hasAttributeValueEndsWith(String attr, String value) {
        isNotNull();
        String attribute = actual.getAttribute(attr);
        if (!attribute.endsWith(value)) {
            failWithMessage("Expected element to have attr <%s> value ends with <%s>. But was <%s>", attr, value, attribute);
        }
        return this;
    }

    public WebElementAssert hasAttributeValueStartsWith(String attr, String value) {
        isNotNull();
        String attribute = actual.getAttribute(attr);
        if (!attribute.startsWith(value)) {
            failWithMessage("Expected element to have attr <%s> value starts with <%s>. But was <%s>", attr, value, attribute);
        }
        return this;
    }

    public WebElementAssert hasAttributeValueStartsWithAnyOf(String attr, String... values) {
        isNotNull();
        String attribute = actual.getAttribute(attr);
        if (!StringUtils.startsWithAny(attribute, values)) {
            failWithMessage("Expected element to have attr <%s> value starts with any of <%s>. But was <%s>", attr, Arrays.toString(values), attribute);
        }
        return this;
    }

    public WebElementAssert hasValueAttribute(String value) {
        isNotNull();
        String valueAttribute = actual.getAttribute("value");
        if (!valueAttribute.equals(value)) {
            failWithMessage("Expected element to have value attribute <%s>. But was <%s>", value, valueAttribute);
        }
        return this;
    }

    public WebElementAssert hasCssValue(String cssAttribute, String value) {
        isNotNull();
        String cssValue = actual.getCssValue(cssAttribute);
        if (!cssValue.equals(value)) {
            failWithMessage("Expected element to have css value <%s> value. But was <%s> value", value, cssValue);
        }
        return this;
    }

    public WebElementAssert isSelected() {
        isNotNull();
        if (!actual.isSelected()) {
            failWithMessage("Expected element to be selected. But was not!!");
        }
        return this;
    }

    public WebElementAssert isNotSelected() {
        isNotNull();
        if (actual.isSelected()) {
            failWithMessage("Expected element to be not selected. But was!!");
        }
        return this;
    }

    public WebElementAssert hasText(String value) {
        isNotNull();
        val text = actual.getText();
        if (!actual.getText().equals(value)) {
            failWithMessage("Expected element to contain text <%s>. But was <%s>!!", value, text);
        }
        return this;
    }

    public WebElementAssert hasTextIgnoreCase(String value) {
        isNotNull();
        val text = actual.getText();
        if (!actual.getText().equalsIgnoreCase(value)) {
            failWithMessage("Expected element to contain text <%s>. But was <%s>!!", value, text);
        }
        return this;
    }

    public WebElementAssert isBlank() {
        isNotNull();
        val text = actual.getText();
        if (!actual.getText().equals(StringUtils.EMPTY)) {
            failWithMessage("Expected element to contain no text. But was <%s>", text);
        }
        return this;
    }

    public WebElementAssert hasAttribute(String attribute) {
        isNotNull();
        if (Objects.isNull(actual.getAttribute(attribute))) {
            failWithMessage("Element has no attribute <%s>", attribute);
        }
        return this;
    }

    public WebElementAssert hasNoAttribute(String attribute) {
        isNotNull();
        if (Objects.nonNull(actual.getAttribute(attribute))) {
            failWithMessage("Element has attribute <%s>", attribute);
        }
        return this;
    }
}