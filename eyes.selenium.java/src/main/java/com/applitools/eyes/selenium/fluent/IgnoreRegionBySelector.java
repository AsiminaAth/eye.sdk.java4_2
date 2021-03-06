package com.applitools.eyes.selenium.fluent;

import com.applitools.eyes.*;
import com.applitools.eyes.fluent.GetRegion;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.EyesSeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IgnoreRegionBySelector implements GetRegion {
    private By selector;

    public IgnoreRegionBySelector(By selector) {
        this.selector = selector;
    }

    @Override
    public List<Region> getRegions(EyesBase eyesBase, EyesScreenshot screenshot) {
        List<WebElement> elements = ((Eyes)eyesBase).getDriver().findElements(this.selector);
        List<Region> values = new ArrayList<>(elements.size());
        for (WebElement element : elements) {

            Point locationAsPoint = element.getLocation();
            RectangleSize size = EyesSeleniumUtils.getElementVisibleSize(element);

            // Element's coordinates are context relative, so we need to convert them first.
            Location adjustedLocation = screenshot.getLocationInScreenshot(
                    new Location(locationAsPoint.getX(), locationAsPoint.getY()),
                    CoordinatesType.CONTEXT_RELATIVE);

            values.add(new Region(adjustedLocation, size, CoordinatesType.SCREENSHOT_AS_IS));
        }
        return values;
    }
}
