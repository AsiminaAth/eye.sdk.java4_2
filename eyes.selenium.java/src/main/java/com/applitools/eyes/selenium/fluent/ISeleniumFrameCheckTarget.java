package com.applitools.eyes.selenium.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ISeleniumFrameCheckTarget {
    Integer getFrameIndex();
    String getFrameNameOrId();
    By getFrameSelector();
    WebElement getFrameReference();
}
