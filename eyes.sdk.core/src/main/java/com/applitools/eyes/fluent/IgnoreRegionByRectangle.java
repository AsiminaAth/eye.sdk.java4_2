package com.applitools.eyes.fluent;

import com.applitools.eyes.EyesBase;
import com.applitools.eyes.EyesScreenshot;
import com.applitools.eyes.Region;

import java.util.ArrayList;
import java.util.List;

public class IgnoreRegionByRectangle implements GetRegion {
    private Region region;

    public IgnoreRegionByRectangle(Region region) {
        this.region = region;
    }

    @Override
    public List<Region> getRegions(EyesBase eyesBase, EyesScreenshot screenshot)
    {
        List<Region> value = new ArrayList<>();
        value.add(this.region);
        return value;
    }
}
